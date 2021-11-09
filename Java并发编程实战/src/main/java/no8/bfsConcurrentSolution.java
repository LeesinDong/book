package no8;

import net.jcip.annotations.GuardedBy;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Leesin Dong
 * @since 2021/11/9
 */
public class bfsConcurrentSolution {
    private final ExecutorService main = Executors.newFixedThreadPool(1);
    private final ExecutorService sub = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    private final ValueLatch solution = new ValueLatch();
    private final Node start = new Node();

    public List<Node> resolve() {
        main.execute(new SolutionTask());
        try {
            return (List<Node>) solution.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            main.shutdown();
        }
    }

    private class SolutionTask implements Runnable {

        @Override
        public void run() {
            if (solution.hasResult()) {
                return;
            }
            if (hasResult()) {
                solution.setValue(getResult());
                return;
            }
            List<Node> nodes = find(start);
            for (Node node : nodes) {
                sub.submit(new SolutionTask());
            }
        }
    }

    // 寻找结果
    private List<Node> find(Node start) {
        return null;
    }

    // 获取结果
    private Node getResult() {
        return null;
    }

    // 找到了结果
    private boolean hasResult() {
        return true;
    }

    private class Node {

    }

    private class ValueLatch {
        @GuardedBy("this")
        private Node value;
        private final CountDownLatch countDownLatch = new CountDownLatch(1);

        public boolean hasResult() {
            return countDownLatch.getCount() == 0;
        }

        public synchronized void setValue(bfsConcurrentSolution.Node node) {
            if (!hasResult()) {
                value = node;
                countDownLatch.countDown();
            }
        }

        public Node getValue() throws InterruptedException {
            countDownLatch.wait();
            synchronized (this) {
                return value;
            }
        }
    }
}
