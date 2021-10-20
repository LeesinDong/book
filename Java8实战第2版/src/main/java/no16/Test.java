package no16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author Leesin Dong
 * @since 2021/10/20
 */
public class Test {

    @org.junit.Test
    public void test() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        // Stream.of("", "")
        CompletableFuture[] completableFutures = integers.stream()
                .map(i -> CompletableFuture.supplyAsync(i::intValue)
                        .thenApply(Integer::intValue)
                        .thenAccept(System.out::println))
                .toArray(size -> new CompletableFuture[size]);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);


        List<CompletableFuture<Integer>> collect = integers.stream()
                .map(i -> CompletableFuture.supplyAsync(i::intValue)
                        .thenApply(Integer::intValue)
                        .exceptionally((e) -> null)
                ).collect(Collectors.toList());

        CompletableFuture[] completableFutures1 = collect.stream().toArray(size -> new CompletableFuture[size]);
        Void join = CompletableFuture.allOf(completableFutures1).join();

        Object join1 = CompletableFuture.anyOf(completableFutures1).join();
        System.out.println("======");
        System.out.println(join1);
    }
}
