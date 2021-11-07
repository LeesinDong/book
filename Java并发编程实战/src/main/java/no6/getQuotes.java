package no6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Leesin Dong
 * @since 2021/11/7
 */
public class getQuotes {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static class QuoteTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "123";
        }
    }

    public static void getQuotes() throws InterruptedException, ExecutionException {
        List<QuoteTask> list = new ArrayList<QuoteTask>();
        list.add(new QuoteTask());
        list.add(new QuoteTask());
        list.add(new QuoteTask());
        List<Future<String>> futures = executorService.invokeAll(list, 10, TimeUnit.SECONDS);

        for (Future<String> future : futures) {
            String s = future.get();
            System.out.println(s);
        }


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        getQuotes();
    }
}
