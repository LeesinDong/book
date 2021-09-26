package no3;

import java.util.concurrent.CompletableFuture;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/24 10:28 下午
 */
public class Test {
    public static final Test INSTANCE = new Test();

    private Test() {
    }

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(Test4::get);
    }

}

enum Test4 {
    INSTANCE;
    public static Test4 get() {
        return INSTANCE;
    }
}

class Test1 {
    private static final Test1 INSTANCE = new Test1();

    private Test1() {
    }

    private static Test1 getInstance() {
        return INSTANCE;
    }
}

class Test2 {
    private static Test2 INSTANCE = null;

    private Test2() {
    }

    private static Test2 getInstance() {
        if (INSTANCE == null) {
            Test2.INSTANCE = new Test2();
        }
        return INSTANCE;
    }

    public static Test2 getInstance1() {
        if (INSTANCE == null) {
            synchronized (Test2.class) {
                if (INSTANCE == null) {
                    Test2.INSTANCE = new Test2();
                }
                return INSTANCE;
            }
        }

        return INSTANCE;
    }
}

class Test5 {
    private Test5() {

    }

    public static Test5 getInstance() {
        return INNER.VALUE;
    }

    private static class INNER {
        private static final Test5 VALUE = new Test5();
    }
}



