package no35;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/29 9:14 上午
 */
public enum Test {
    one, three, two;
    public int get() {
        return ordinal();
    }

    private static class Test1 {
        public static void main(String[] args) {
            int i = Test.three.get();
            System.out.println(i);
        }
    }
}
