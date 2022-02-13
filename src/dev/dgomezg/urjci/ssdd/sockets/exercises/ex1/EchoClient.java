package dev.dgomezg.urjci.ssdd.sockets.exercises.ex1;

import java.io.IOException;
import java.net.Socket;

public class EchoClient {

    public static final String SERVER_HOST = "localhost";
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        //DONE: create a socket connection to the server
        try (Socket socket = new Socket(SERVER_HOST, PORT)) {
            System.out.println("Connected to server on " + socket.getRemoteSocketAddress());

            //TODO: Read a line from standard input and send it to Server
            //TODO: wait for server response and print on the standard output
            //TODO: Don't forget to close the resources (Input/OutputStreams)

        } //Socket (Autocloseable) closed implicitly
    }
}
