package loggerLib.layouts;

import loggerLib.enumarations.ReportLevel;
import loggerLib.layouts.interfaces.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %S - %s", date, reportLevel.toString(), message);
    }
}
