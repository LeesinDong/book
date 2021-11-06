package no6;

import java.util.concurrent.*;

/**
 * @author Leesin Dong
 * @since 2021/11/6
 */
public class Render {
    private final static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void render() throws ExecutionException, InterruptedException {
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i < 100; i++) {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "12345";
                }
            });
        }

        // 同步操作
        System.out.println("11111");

        for (int i = 0; i < 100; i++) {
            Future<String> take = completionService.take();
            String s = take.get();
            System.out.println(s);
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        render();
        executorService.shutdownNow();
    }

}
