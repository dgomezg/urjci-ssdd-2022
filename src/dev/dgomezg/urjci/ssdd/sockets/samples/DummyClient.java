package dev.dgomezg.urjci.ssdd.sockets.samples;

import java.io.IOException;
import java.net.Socket;

public class DummyClient {

    public static final String SERVER_HOST = "localhost";
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(SERVER_HOST, PORT)) {
            System.out.println("Connected to server " + socket.getInetAddress()
                    + " on LocalPort " + socket.getLocalPort());
        } //Socket (autocloseable) implicitly closed
    }
}
