package ca.cal.tp2;

import org.h2.tools.Server;

import java.sql.SQLException;

public class TcpServer {
    public static void startTcpServer() throws SQLException {
        final Server tcpServer = Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        System.out.println("Tcp server start: " + tcpServer.start());
        System.out.println(tcpServer.getStatus() + " " +
                tcpServer.getPort());
        System.out.println("jdbc:h2:tcp://localhost:9092/mem:exerciceJdbc");
    }
}