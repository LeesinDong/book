package no2.Observer;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class Test {
    @org.junit.Test
    public void test() {
        Subject subject = new Subject();
        subject.add(new Observer());
        subject.inform();
    }
}
