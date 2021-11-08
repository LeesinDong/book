package no7;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class Poison {
    private static final File poison = new File("");
    private final File root = new File("");
    private final Queue queue = new LinkedBlockingQueue();

    public void main(String[] args) {
        new Thread(() -> {
            queue.offer(root);
            queue.offer(poison);
        }).start();

        new Thread(() -> {
            while (true) {
                Object poll = queue.poll();
                if (poll == poison) {
                    break;
                }
                // 正常消费
                // consume（poll）
            }
        }).start();
    }
}
