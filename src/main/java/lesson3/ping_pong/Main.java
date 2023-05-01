package lesson3.ping_pong;

public class Main {

    public static void main(String[] args) {
        PingPongMonitor monitor = new PingPongMonitor();
    new Pong(monitor);
    new Ping(monitor);
    }
}
