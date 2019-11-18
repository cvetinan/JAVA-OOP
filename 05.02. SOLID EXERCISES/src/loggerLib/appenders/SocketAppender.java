package loggerLib.appenders;

import loggerLib.enumarations.ReportLevel;
import loggerLib.layouts.interfaces.Layout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketAppender extends AppenderImpl {
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;

    public SocketAppender(Layout layout) throws IOException {
        super(layout);
        InetAddress address = InetAddress.getLocalHost();
        this.startConnection(address, 21);
    }

    public void startConnection(InetAddress ip, int port) throws IOException {
        this.client = new Socket(ip, port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    private void sendMessage(String msg) throws IOException {
        out.println(msg);
        //in.readLine();
        stopConnection();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        client.close();
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) throws IOException {
        this.sendMessage(this.format(date, reportLevel, message));
    }
}
