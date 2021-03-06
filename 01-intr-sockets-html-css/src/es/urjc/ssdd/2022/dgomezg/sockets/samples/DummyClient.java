package sockets.samples;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class DummyClient {

    public static final String SERVER_HOST = "localhost";
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(SERVER_HOST, PORT)) {
            System.out.println("Connected to server " + socket.getInetAddress()
                    + " on LocalPort " + socket.getLocalPort());

            sendSomeData(socket);

        } //Socket (autocloseable) implicitly closed
    }

    private static void sendSomeData(Socket socket) throws IOException {

        try (   OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream)) {

            writer.println("UNO");
            writer.println("DOS");
            writer.println("CUATRO");
            writer.println("CATORCE");
            writer.println(DummyServer.EOT_COMMAND);

        } //OutputStream & Writer (autocloseable) implicitly closed.
    }
}
