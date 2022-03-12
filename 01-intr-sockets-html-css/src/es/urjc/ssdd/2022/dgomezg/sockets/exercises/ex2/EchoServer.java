package sockets.exercises.ex2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int PORT = 8080;
    public static final String EOT_COMMAND = "x";

    public static void main(String[] args) throws IOException {
        //DONE: Open a ServerSocket listening on PORT 8080 (or any other available port)
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Listening on " + serverSocket.getLocalSocketAddress());

            //DONE: Accept connections from serverSocket and get serviceSocket
            try (Socket serviceSocket = serverSocket.accept()) {
                System.out.println("Accepted connection on port " + serviceSocket.getPort());
                processRequest(serviceSocket);
            }
        } //DONE: Don't forget to close the resources (Sockets...)
    }

    private static void processRequest(Socket serviceSocket) throws IOException {
        try (   InputStream inputStream = serviceSocket.getInputStream();
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
