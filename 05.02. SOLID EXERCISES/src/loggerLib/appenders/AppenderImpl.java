package loggerLib.appenders;

import loggerLib.appenders.interfaces.Appender;
import loggerLib.enumarations.ReportLevel;
import loggerLib.layouts.interfaces.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int loggedMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.loggedMessages = 0;
    }

    protected AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        setReportLevel(reportLevel);
        this.loggedMessages = 0;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected String format(String date, ReportLevel reportLevel, String message) {
        this.loggedMessages++;
        return this.layout.format(date, reportLevel, message);
    }

    @Override
    public String toString() {
        return String.format(
                "Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName()
                , this.layout.getClass().getSimpleName()
                , this.reportLevel.toString()
                , this.loggedMessages
        );
    }
}
