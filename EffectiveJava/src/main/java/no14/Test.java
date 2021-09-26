package no14;

import java.util.Comparator;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/25 4:39 下午
 */
public class Test implements Comparable<Test>{
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(a));
        System.out.println(b.compareTo(a));

        System.out.println(new Test(1, 2).compareTo(new Test(2, 1)));
    }



    @Override
    public int compareTo(Test o) {
        return this.a - o.a;
    }

    private int a;
    private int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // 静态比较器
    public static final Comparator<Test> COMPARE = Comparator.comparingInt((Test i) -> i.a).thenComparingInt(i -> i.b);

    Comparator<Test> test = (o1, o2) -> Integer.compare(o1.a, o2.a);
}
