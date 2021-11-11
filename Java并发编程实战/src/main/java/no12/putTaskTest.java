package no12;

import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * @author Leesin Dong
 * @since 2021/11/11
 */
public class putTaskTest {
    Constructor constructor = new Constructor(2);
    @Data
    private class Constructor {
        private final CyclicBarrier cyclicBarrier;
        private final AtomicInteger takeNum = new AtomicInteger(0);
        private final AtomicInteger putNum = new AtomicInteger(0);
        private final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        private int nPari = 2;

        public Constructor(int nPari) {
            this.cyclicBarrier = new CyclicBarrier(2 * nPari + 1);
        }
    }

    @Test
    public void test() throws InterruptedException, BrokenBarrierException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < constructor.nPari; i++) {
            executorService.execute(new Producer());
            executorService.execute(new Consumer());
        }
        constructor.cyclicBarrier.await();
        constructor.cyclicBarrier.await();
        System.out.println(111);
        System.out.println(constructor.putNum.get());
        System.out.println(constructor.takeNum.get());
        assertEquals(constructor.putNum.get(), constructor.takeNum.get());
    }

    private class Producer implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            constructor.cyclicBarrier.await();
            constructor.linkedBlockingQueue.put(1);
            System.out.println("put");
            constructor.putNum.getAndIncrement();
            constructor.cyclicBarrier.await();
            System.out.println("put await");
        }
    }

    private class Consumer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            constructor.cyclicBarrier.await();
            Object take = constructor.linkedBlockingQueue.take();
            System.out.println("take");
            constructor.takeNum.getAndIncrement();
            constructor.cyclicBarrier.await();
            System.out.println("get await");
        }
    }
}
