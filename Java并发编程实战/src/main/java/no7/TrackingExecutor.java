package no7;

import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 包装的Executor
 *
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class TrackingExecutor extends AbstractExecutorService {
    private final ExecutorService exec;
    private final Set<Runnable> tasksCancelledAtShutdown = new ConcurrentSkipListSet<>();

    public TrackingExecutor(ExecutorService exec) {
        this.exec = exec;
    }

    public Set<Runnable> getTasksCancelledAtShutdown() {
        return tasksCancelledAtShutdown;
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable command) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                } finally {
                    if (isShutdown() && Thread.currentThread().isInterrupted()) {
                        tasksCancelledAtShutdown.add(command);
                    }
                }
            }
        });
    }
}
