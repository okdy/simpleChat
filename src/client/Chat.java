package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Chat implements Runnable {

    SocketAddress address;
    Socket sock;

    public Chat(String host, int port) {
        address = new InetSocketAddress(host, port);
        sock = new Socket();
    }

    public void connect() throws IOException {
        sock.connect(address);
    }

    @Override
    public void run() {
        try {
            connect();
        } catch (IOException e) {
            System.out.println("connect is failed");
        }

    }
}
