package lesson3.counter;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();
        for(int i = 0; i < 100; i++) {
          new Thread(new Runnable() {

              @Override
              public void run() {
                  for(int i = 0; i < 10; i++) {
                      counter.increase(Thread.currentThread().getName());
                  }
              }
          }).start();
        }
    }
}
