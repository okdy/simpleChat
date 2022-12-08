package server;

public class Server {

    public static void main(String[] args) {
        SocketProcess socketProcess = new SocketProcess();
        Thread thread = new Thread(socketProcess);
        thread.start();
    }

}
