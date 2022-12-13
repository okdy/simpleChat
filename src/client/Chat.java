package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Chat implements Runnable {

    SocketAddress address;
    Socket sock;

    public void connect(String host, int port)  {
        address = new InetSocketAddress(host, port);
        try {
            sock.connect(address);
        } catch (IOException e) {
            System.out.println("sibal haha");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {


    }
}
