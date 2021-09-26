package no2;

public class Test {
    private int a;
    private int b;
    private int c;

    public static class Builder {
        private int a;
        private int b;
        private int c;

        public Builder(int a) {
            this.a = a;
        }

        public Builder b(int b) {
            this.b = b;
            return this;
        }

        public Builder c(int c) {
            this.c = c;
            return this;
        }

        public Test build() {
            Test test = new Test();
            test.a = this.a;
            test.b = this.b;
            test.c = this.c;
            return  test;
        }


    }

    public static void main(String[] args) {
        Test build = new Builder(1).b(2).c(3).build();
        System.out.println(build.toString());
    }

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
