package lesson3.counter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
   private int counter;
   private Lock lock;

   public Counter() {
       counter = 0;
       lock = new ReentrantLock();

   }

   public  void increase(String name) {
       lock.lock();
       try {
           counter++;
           System.out.println(String.format("Increased till %s by %s",counter, name));
       } finally {
           lock.unlock();
       }
   }
}
