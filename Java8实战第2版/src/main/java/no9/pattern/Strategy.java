package no9.pattern;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Strategy {
    @Test
    public void test() {
        boolean execute = new client((s) -> s.equals("1234")).execute("1234");
        System.out.println(execute);
        boolean execute1 = new client((s) -> s.equals("12345")).execute("12345");
        System.out.println(execute1);
    }

    private interface ValidationStrategy{
        boolean execute(String string);
    }

    private  class client {
        private ValidationStrategy validationStrategy;

        public client(ValidationStrategy validationStrategy) {
            this.validationStrategy = validationStrategy;
        }

        public boolean execute(String string) {
            return validationStrategy.execute(string);
        }
    }
}
