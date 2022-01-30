package dev.dgomezg.urjci.ssdd.sockets.samples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Listening on  "
                    + serverSocket.getLocalSocketAddress());

            try (Socket serviceSocket = serverSocket.accept()) {
                System.out.println("Service Socket for request open on port "
                        + serviceSocket.getPort());
            } // serviceSocket (Autocloseable) is properly closed by try-with-resources
        } // serverSocket (Autocloseable) is properly closed by try-with-resources
    }
}
