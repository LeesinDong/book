package no7;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class WebCrawler {
    private final TrackingExecutor trackingExecutor;
    private final List<Runnable> unCrawlers = new CopyOnWriteArrayList<>();

    public WebCrawler(TrackingExecutor trackingExecutor) {
        this.trackingExecutor = trackingExecutor;
    }

    public void stop() throws InterruptedException {
        List<Runnable> runnableTasks = trackingExecutor.shutdownNow();
        saveUncrawled(runnableTasks);
        if (trackingExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
            Set<Runnable> tasksCancelledAtShutdown = trackingExecutor.getTasksCancelledAtShutdown();
            saveUncrawled(tasksCancelledAtShutdown);
        }
    }

    public void saveUncrawled(Collection<Runnable> runnable) {
        unCrawlers.addAll(runnable);
    }
}
