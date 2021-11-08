package no7;

import net.jcip.annotations.GuardedBy;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class LogService {
    @GuardedBy("this") private int count;
    @GuardedBy("this") private boolean isShotDown;
    private final BlockingQueue queue;
    private final PrintWriter writer;
    private final LoggerThread loggerThread;

    public LogService(int count, boolean isShotDown, BlockingQueue queue, PrintWriter writer, LoggerThread loggerThread) {
        this.count = count;
        this.isShotDown = isShotDown;
        this.queue = queue;
        this.writer = writer;
        this.loggerThread = loggerThread;
    }

    public void start() {
        loggerThread.start();
    }

    public void stop() {
        isShotDown = true;
        loggerThread.isInterrupted();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this) {
            if (isShotDown) {
                throw new RuntimeException("服务已关闭");
            }
            count++;
        }
        queue.put(msg);
    }

    private class LoggerThread extends Thread{
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (this) {
                        if (isShotDown && count == 0) {
                            break;
                        }
                        count--;
                    }

                    try {
                        Object take = queue.take();
                        writer.println(take);
                    } catch (InterruptedException e) {
                    }
                }
            } finally {
                writer.close();
            }
        }
    }
}
