package client;

import common.ChatMember;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Chat implements Runnable {

    SocketAddress address;
    Socket sock;

    public void connect(String host, int port)  {
        address = new InetSocketAddress(host, port);
        sock = new Socket();

        try {
            sock.connect(address);
            OutputStream outputStream = sock.getOutputStream();

            outputStream.write(setMessageBytes(Main.chatMember, "하하..."));
            outputStream.close();
        } catch (IOException e) {
            System.out.println("haha");
            throw new RuntimeException(e);
        }
    }

    public byte[] setMessageBytes(ChatMember chatMember, String message) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

        chatMember.setMessage(message);

        try (byteArrayOutputStream) {
            try (objectOutputStream) {
                objectOutputStream.writeObject(chatMember);
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override
    public void run() {


    }
}
