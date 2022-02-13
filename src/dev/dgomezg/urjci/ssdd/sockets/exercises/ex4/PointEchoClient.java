package dev.dgomezg.urjci.ssdd.sockets.exercises.ex4;

import java.io.*;
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

    private static void sendToServerAndAwaitResponse(Socket socket)
            throws IOException {
        try (socket;
             ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream objectInputStream =
                     new ObjectInputStream(socket.getInputStream());
        ) {
            //TODO Serialize and Send Point to Server
            Point3d point = new Point3d(1,2, 3);
            objectOutputStream.writeObject(point);
            objectOutputStream.flush();
            //TODO Read response, deserialize Point and print.
            Point3d response = (Point3d) objectInputStream.readObject();
            System.out.println("> " + response.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading response from server "
                    + e.getMessage());
        }
    }


}
