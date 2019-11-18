package loggerLib.logFiles.interfaces;

public interface File {
    void write();
    int getSize();
    void appendBuffer(String text);
}
