package no3_8_1;

/**
 * @author Leesin Dong
 * @since 2021/10/24
 */
public class Test {
    private static final int _1MB = 1024 * 1024;

    // JVM参数
    // java -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails test.java

    public static void main(String[] args) throws InterruptedException {
        test();
        Thread.sleep(8000);
    }

    public static void test() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
