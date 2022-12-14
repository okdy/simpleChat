package server;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        SocketProcess socketProcess = new SocketProcess();
        Thread thread = new Thread(socketProcess);
        thread.start();
        thread.join();
    }

}
