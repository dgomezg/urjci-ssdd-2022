package dev.dgomezg.urjci.ssdd.sockets.exercises.ex4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PointEchoServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server Listening on " + serverSocket.getLocalSocketAddress());

            while(true) {
                Socket serviceSocket = serverSocket.accept();
                System.out.println("Accepted connection on port " + serviceSocket.getPort());
                new Thread( () -> processRequest(serviceSocket) )
                        .start();
            }
        }
    }

    private static void processRequest(Socket serviceSocket)  {
        //TODO: Receive a Point3d from the client
        //TODO: Send the Point3d back to the client
        //TODO: Print the received point.
    }
}
