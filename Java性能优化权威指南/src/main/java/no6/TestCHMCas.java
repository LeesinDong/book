package no6;

import lombok.Builder;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Leesin Dong
 * @since 2021/11/18
 */
public class TestCHMCas {
    private ConcurrentHashMap<String, Innter> chm = new ConcurrentHashMap<>();
    private static final Random random = new Random();

    private void test() {
        for (int i = 0; i < 100; i++) {
            Innter innter = chm.get("1");
            innter.getAtomic().compareAndSet(1, random.nextInt());
        }
    }

    @Builder
    @Data
    private static class Innter {
        private AtomicInteger atomic = new AtomicInteger();
    }
}
