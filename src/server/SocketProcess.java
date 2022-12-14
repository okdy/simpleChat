package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketProcess implements Runnable {

    private final String hostName = "127.0.0.1";
    private final int portNumber = 1234;

    public ServerSocket socketOpen() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(hostName, portNumber);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(socketAddress);

        while (true) {
            Socket socket = serverSocket.accept();
            OutputStream os = socket.getOutputStream();
            os.write("sibal".getBytes());
            socket.close();;
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
