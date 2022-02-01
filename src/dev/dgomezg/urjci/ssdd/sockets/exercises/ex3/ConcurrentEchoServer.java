package dev.dgomezg.urjci.ssdd.sockets.exercises.ex3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrentEchoServer {

    public static final int PORT = 8080;
    public static final String EOT_COMMAND = "x";

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Listening on " + serverSocket.getLocalSocketAddress());

            //TODO: Attend each request in a different Thread.
            try (Socket serviceSocket = serverSocket.accept()) {
                System.out.println("Accepted connection on port " + serviceSocket.getPort());
                processRequest(serviceSocket);
            }
        }
    }

    private static void processRequest(Socket serviceSocket) throws IOException {
        try (InputStream inputStream = serviceSocket.getInputStream();
             BufferedReader socketReader =
                     new BufferedReader(new InputStreamReader(inputStream));
             OutputStream outputStream = serviceSocket.getOutputStream();
             PrintWriter socketWriter = new PrintWriter(outputStream, true)) {

            String line = null;
            while ( (line = socketReader.readLine()) != null
                    && !line.equals(EOT_COMMAND)) {
                System.out.println("< " + line);
                socketWriter.println("> " + line);
            }

        } // Autocloseable resources implicitly closed.

    }
}