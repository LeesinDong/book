package no7;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class LogServiceWithExecutor {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private PrintWriter printWriter;

    public void stop() throws InterruptedException {
        try {
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } finally {
            printWriter.close();
        }
    }
}
