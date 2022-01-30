package dev.dgomezg.urjci.ssdd.sockets.samples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server Listening on  "
                + serverSocket.getLocalSocketAddress());

        Socket serviceSocket = serverSocket.accept();
        System.out.println("Service Socket for request open on port "
                + serviceSocket.getPort());

    }
}
