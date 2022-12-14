package server;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        SocketProcess socketProcess = new SocketProcess("127.0.0.1", 1234);
        Thread thread = new Thread(socketProcess);
        thread.start();
        thread.join();
    }

}
