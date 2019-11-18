import loggerLib.appenders.SocketAppender;
import loggerLib.appenders.interfaces.Appender;
import loggerLib.layouts.XmlLayout;
import loggerLib.layouts.interfaces.Layout;
import loggerLib.loggers.MessageLogger;
import loggerLib.loggers.interfaces.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Layout layout = new XmlLayout();
        Appender appender = new SocketAppender(layout);
        Logger logger = new MessageLogger(appender);

        String currentDateTime = String.valueOf(LocalDateTime.now());
        logger.logInfo(currentDateTime, "Connection successful!");


        /***
         * @implNote
         * This main method used before create SocketAppender,
         * hidden while testing SocketAppender Implementation
         *
         * @hidden
        int lines = Integer.parseInt(scanner.nextLine());
        Appender[] appenders = new Appender[lines];
        int index = 0;

        while (lines-- > 0) {
        String[] tokens = scanner.nextLine().split("\\s+");

        Layout layout = null;

        if (tokens[1].equals("SimpleLayout")) {
        layout = new SimpleLayout();
        } else {
        layout = new XmlLayout();
        }

        Appender appender = null;

        if (tokens[0].equals("ConsoleAppender")) {
        appender = new ConsoleAppender(layout);
        } else if (tokens[0].equals("FileAppender")){
        appender = new FileAppender(layout);
        }

        if (tokens.length == 3) {
        assert appender != null;
        appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }

        appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String line = scanner.nextLine();

        while (!line.equals("END")) {
        String[] tokens = line.split("\\|");

        switch (ReportLevel.valueOf(tokens[0])) {
        case INFO:
        logger.logInfo(tokens[1], tokens[2]);
        break;
        case WARNING:
        logger.logWarning(tokens[1], tokens[2]);
        break;
        case ERROR:
        logger.logError(tokens[1], tokens[2]);
        break;
        case CRITICAL:
        logger.logCritical(tokens[1], tokens[2]);
        break;
        case FATAL:
        logger.logFatal(tokens[1], tokens[2]);
        break;
        }
        line = scanner.nextLine();
        }
        System.out.println(logger.toString());*/
    }
}