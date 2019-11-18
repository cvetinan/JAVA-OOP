import loggerLib.appenders.ConsoleAppender;
import loggerLib.appenders.FileAppender;
import loggerLib.appenders.SocketAppender;
import loggerLib.appenders.interfaces.Appender;
import loggerLib.enumarations.ReportLevel;
import loggerLib.layouts.SimpleLayout;
import loggerLib.layouts.XmlLayout;
import loggerLib.layouts.interfaces.Layout;
import loggerLib.loggers.MessageLogger;
import loggerLib.loggers.interfaces.Logger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        Appender[] appenders = new Appender[lines];
        int index = 0;

        while (lines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Layout layout = null;

            if (tokens[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else if (tokens[1].equals("XmlLayout")) {
                layout = new XmlLayout();
            }

            Appender appender = null;

            switch (tokens[0]) {
                case "ConsoleAppender":
                    appender = new ConsoleAppender(layout);
                    break;
                case "FileAppender":
                    appender = new FileAppender(layout);
                    break;
                case "SocketAppender":
                    appender = new SocketAppender(layout);
                    break;
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
            String currentDateTime = getCurrentDateTime();
            String message = tokens[1];
            switch (ReportLevel.valueOf(tokens[0])) {
                case INFO:
                    logger.logInfo(currentDateTime, message);
                    break;
                case WARNING:
                    logger.logWarning(currentDateTime, message);
                    break;
                case ERROR:
                    logger.logError(currentDateTime, message);
                    break;
                case CRITICAL:
                    logger.logCritical(currentDateTime, message);
                    break;
                case FATAL:
                    logger.logFatal(currentDateTime, tokens[1]);
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.println(logger.toString());
    }

    private static String getCurrentDateTime() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/uuuu HH:MM:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(formatters);
    }
}