package dev.dgomezg.urjci.ssdd.sockets.exercises.ex2;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int PORT = 8080;

    public static void main(String[] args) {
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

    private static void processRequest(Socket serviceSocket) {
        //TODO: Process the request received through serviceSocket
        //DONE: Don't forget to close the resources (Sockets, InputStreams...)
    }
}
