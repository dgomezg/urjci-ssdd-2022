package dev.dgomezg.urjci.ssdd.sockets.samples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket serviceSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server Listening on  "
                    + serverSocket.getLocalSocketAddress());

            serviceSocket = serverSocket.accept();
            System.out.println("Service Socket for request open on port "
                    + serviceSocket.getPort());
        } finally {
            if (serviceSocket != null) {
                try {
                    serviceSocket.close();
                } catch (Exception ex) {
                    // close() can throw an exception and
                    // even if we are not going to handle it,
                    // we need to catch it to allow the finally block
                    // to properly close the serverSocket
                }
            }
            if (serverSocket != null) {
                //No need to catch Exception, as this is the last resource
                serverSocket.close();
            }
        }
    }
}
