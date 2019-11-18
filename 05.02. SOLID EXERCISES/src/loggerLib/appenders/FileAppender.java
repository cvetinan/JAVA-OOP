package loggerLib.appenders;

import loggerLib.enumarations.ReportLevel;
import loggerLib.layouts.interfaces.Layout;
import loggerLib.logFiles.LogFile;
import loggerLib.logFiles.interfaces.File;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        setFile(file);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        setFile(file);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (this.file == null){
            //throw new NullPointerException("File reference is not set");
            try {
                this.setFile(new LogFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.file.appendBuffer(this.format(date,reportLevel,message));
        this.file.write();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
