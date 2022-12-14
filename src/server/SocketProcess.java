package server;

import common.ChatMember;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Base64;

public class SocketProcess implements Runnable {

    private String hostName;
    private int portNumber;

    public SocketProcess(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public ServerSocket socketOpen() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(hostName, portNumber);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(socketAddress);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            byte[] result = inputStream.readAllBytes();
            getMessage(result);
            inputStream.close();
        }
    }

    public void getMessage(byte[] serializedData) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        try (byteArrayInputStream) {
            try (objectInputStream) {
                Object tempObject = (Object) objectInputStream.readObject();
                ChatMember chatMember = (ChatMember) tempObject;
                System.out.println(chatMember);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        try {
            socketOpen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
