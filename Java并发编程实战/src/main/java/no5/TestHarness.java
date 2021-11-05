package no5;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author Leesin Dong
 * @since 2021/11/5
 */
public class TestHarness {
  public void timeTasks(int nThreads) throws InterruptedException {
      final CountDownLatch startGate = new CountDownLatch(2);
      final CountDownLatch endGate = new CountDownLatch(nThreads);

      for (int i = 0; i < nThreads; i++) {
          Thread t = new Thread() {
              @Override
              @SneakyThrows
              public void run() {
                  startGate.await();
                  System.out.println("a");
                  endGate.countDown();
              }
          };
          t.start();
      }

      long start = System.nanoTime();
      // startGate.countDown();
      startGate.countDown();
      new Thread(() -> {
          startGate.countDown();
      }).start();

      endGate.await();
      long end = System.nanoTime();
      System.out.println(end - start);
  }

  @Test
  public void test() throws InterruptedException {
      try {
          timeTasks(3);
      } catch (InterruptedException e) {
          Throwable cause = e.getCause();
      }
  }
}
