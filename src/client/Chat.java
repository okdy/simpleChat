package client;

import java.io.IOException;
import java.io.InputStream;
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

            InputStream is = sock.getInputStream();
            Main.chat.append("test\n");
        } catch (IOException e) {
            System.out.println("haha");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {


    }
}
