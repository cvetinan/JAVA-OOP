import loggerLib.appenders.ConsoleAppender;
import loggerLib.appenders.FileAppender;
import loggerLib.appenders.interfaces.Appender;
import loggerLib.enumarations.ReportLevel;
import loggerLib.layouts.SimpleLayout;
import loggerLib.layouts.XmlLayout;
import loggerLib.layouts.interfaces.Layout;
import loggerLib.loggers.MessageLogger;
import loggerLib.loggers.interfaces.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Appender[] appenders = new Appender[lines];
        int index = 0;

        while (lines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Appender appender = null;

            Layout layout = null;

            if (tokens[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }
            if (tokens[0].equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else {
                appender = new FileAppender(layout);
            }

            if (tokens.length == 3) {
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

        System.out.println(logger.toString());
    }
}
