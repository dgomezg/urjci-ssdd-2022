package dev.dgomezg.urjci.ssdd.sockets.exercises.ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PointEchoClient {
    public static final String SERVER_HOST = "localhost";
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(SERVER_HOST, PORT)) {
            System.out.println("Connected to server on " + socket.getRemoteSocketAddress());

            sendToServerAndAwaitResponse(socket);

        } //Socket (Autocloseable) closed implicitly
    }

    private static void sendToServerAndAwaitResponse(Socket socket) {
        //TODO Serialize and Send Point to Server
        //TODO Read response, deserialize Point and print.
    }


}
