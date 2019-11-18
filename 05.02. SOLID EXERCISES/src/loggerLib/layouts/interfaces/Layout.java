package loggerLib.layouts.interfaces;

import loggerLib.enumarations.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
