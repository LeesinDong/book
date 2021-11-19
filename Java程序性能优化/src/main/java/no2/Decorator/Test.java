package no2.Decorator;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class Test {
    @org.junit.Test
    public void test() {
        HTTPDecorator httpDecorator = new HTTPDecorator(new HTMLDecorator(new Body()));
        System.out.println(httpDecorator.print());;
    }
}
