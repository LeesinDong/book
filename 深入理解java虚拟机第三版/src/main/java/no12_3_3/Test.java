package no12_3_3;

/**
 * @author Leesin Dong
 * @since 2021/10/28
 */
public class Test {
    // static volatile int i = 1;
    // public static void main(String[] args) {
    //     for (int i1 = 0; i1 < 20; i1++) {
    //         new Thread(() -> {
    //             for (int i2 = 0; i2 < 10000; i2++) {
    //                 // i++;
    //                 i = i + 1;
    //             }
    //         }).start();
    //     }
    //
    //     System.out.println(i);
    // }

    static volatile boolean work = true;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                work();
            }).start();
        }

        Thread.sleep(5000);

        work = false;
    }

    public static void work() {
        while (work) {
            System.out.println("work");
        }
    }
}
