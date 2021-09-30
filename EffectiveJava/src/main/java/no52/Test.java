package no52;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/30 5:02 下午
 */
public class Test {

    interface A {
        /**
         * aaa
         * @inheritDoc a
         */
        void test();
    }

    private static class son implements A{

        /**
         * @inheritDoc
         */
        @Override
        public void test() {

        }
    }
    /**
     *
     *
     * @param args  {@code i + 1 = 2}
     */
    public static void main(String[] args) {
        new Thread(System.out::println).start();
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.submit(System.out::println);
    }
}
