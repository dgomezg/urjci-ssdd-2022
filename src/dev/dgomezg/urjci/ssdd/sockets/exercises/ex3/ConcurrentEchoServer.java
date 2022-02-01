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

            while(true) {
                Socket serviceSocket = serverSocket.accept();
                System.out.println("Accepted connection on port " + serviceSocket.getPort());
                Thread workerThread = new Thread( () -> {
                    /* try must be moved to the thread,
                     * with the try-with-resources outside of the thread
                     * the socket would be closed externally and not accessible
                     * by the thread.
                     */
                    // try-with-resources can be used with existing resources
                    //Since Java 9, resource can be simply reused
                    try(serviceSocket) {
                        processRequest(serviceSocket);
                    } catch (IOException e) {
                        System.out.println("Error processing request from "
                                + serviceSocket.getPort()
                                + ". Exception: "
                                + e.getMessage());
                    }
                });
                workerThread.start();

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
                System.out.printf("[%s]< %s\n",
                        Thread.currentThread().getName(),
                        line);
                socketWriter.println("> " + line);
            }

        } // Autocloseable resources implicitly closed.

    }
}
