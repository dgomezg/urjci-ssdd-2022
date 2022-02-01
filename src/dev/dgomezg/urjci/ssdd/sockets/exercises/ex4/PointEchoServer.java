package dev.dgomezg.urjci.ssdd.sockets.exercises.ex4;

import java.io.IOException;
import java.io.ObjectInputStream;
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
        try(serviceSocket;
            ObjectInputStream socketReader =
                    new ObjectInputStream(serviceSocket.getInputStream());
        ) {
            //TODO: Receive a Point3d from the client
            Point3d point = (Point3d) socketReader.readObject();
            //TODO: Send the Point3d back to the client
            System.out.printf("[%s] Received point %s\n",
                    Thread.currentThread().getName(),
                    point.toString());
            //TODO: Print the received point.
        } catch (Exception ex) {
            System.out.printf("[%s] Error handling request. Cause %s\n",
                    Thread.currentThread().getName(),
                    ex.getMessage());
        }
    }
}
