package lesson3.ping_pong;

import static java.lang.Thread.sleep;

public class Ping implements Runnable {
    PingPongMonitor monitor;
    public Ping(PingPongMonitor monitor) {
        this.monitor = monitor;
        new Thread(this, "Ping").start();

    }
    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            i++;
            monitor.ping();
        }
    }

}
