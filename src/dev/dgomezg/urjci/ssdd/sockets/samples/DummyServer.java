package dev.dgomezg.urjci.ssdd.sockets.samples;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DummyServer {

    public static final int PORT = 8080;
    public static final String EOT_COMMAND = "bye";

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Listening on  "
                    + serverSocket.getLocalSocketAddress());

            try (Socket serviceSocket = serverSocket.accept()) {
                System.out.println("Service Socket for request open on port "
                        + serviceSocket.getPort());
                processRequest(serviceSocket);
            } // serviceSocket (Autocloseable) is properly closed by try-with-resources
        } // serverSocket (Autocloseable) is properly closed by try-with-resources
    }

    private static void processRequest(Socket serviceSocket) throws IOException {
        try (
                InputStream inputStream = serviceSocket.getInputStream();
                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(inputStream)) ) {
            String line = null;
            while (!(line = reader.readLine()).equalsIgnoreCase(EOT_COMMAND)) {
                System.out.println("> " + line);
            }
        } //inputStream & BufferedReader (autocloseable) implicitly closed
    }
}
