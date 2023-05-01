package lesson3.ping_pong;

public class PingPongMonitor {

    public boolean flag = true;
    public synchronized void ping() {
        while(!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("PING");
        flag = false;
        notify();

    }

    public synchronized void pong() {
        while(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("PONG");
        flag = true;
        notify();

    }
}
