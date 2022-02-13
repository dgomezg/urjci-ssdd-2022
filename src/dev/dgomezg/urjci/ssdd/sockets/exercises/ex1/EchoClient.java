package dev.dgomezg.urjci.ssdd.sockets.exercises.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static final String SERVER_HOST = "localhost";
    public static final int PORT = 8080;
    public static final String EOT_COMMAND = "x";


    public static void main(String[] args) throws IOException {
        //DONE: create a socket connection to the server
        try (Socket socket = new Socket(SERVER_HOST, PORT)) {
            System.out.println("Connected to server on " + socket.getRemoteSocketAddress());

            sendToServerMessagesFromStandardInput(socket);
        } //Socket (Autocloseable) closed implicitly
    }

    private static void sendToServerMessagesFromStandardInput(Socket socket)
            throws IOException {

        try (BufferedReader keyboardReader =
                     new BufferedReader(new InputStreamReader(System.in));
             BufferedReader socketReader =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String line;
            //DONE: Read a line from standard input
            while ( (line = keyboardReader.readLine()) != null
                    && !line.equals(EOT_COMMAND)) {
                sendToServerAndPrintResponse(socketReader, socketWriter, line);
            }
        } //DONE: keyboardReader (autocloseable) implicitly closed
    }

    private static void sendToServerAndPrintResponse(BufferedReader socketReader, PrintWriter socketWriter, String line) throws IOException {
        //DONE: Send line to server
        socketWriter.println(line);
        //DONE: wait for server response and print on the standard output
        System.out.println("> " + socketReader.readLine());
    }


}
