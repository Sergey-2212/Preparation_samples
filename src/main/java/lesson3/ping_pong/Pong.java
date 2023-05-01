package lesson3.ping_pong;

import static java.lang.Thread.sleep;

public class Pong implements Runnable {
    PingPongMonitor monitor;
    public Pong(PingPongMonitor monitor) {
       this.monitor = monitor;
        new Thread(this, "Pong").start();

    }
    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
                i++;
                monitor.pong();

        }
    }

}
