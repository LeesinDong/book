package no34;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/28 10:36 下午
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y) {
        switch (this) {
            case PLUS: return x + y;
            case MINUS: return x - y;
            case TIMES :return x * y;
            case DIVIDE: return x / y;
        }
        throw new AssertionError("");
    }

    public Operation get(String name) {
        Operation operation = valueOf(name);
        return operation;
    }

    enum improve {
        PLUS {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },;

        public abstract double apply(double x, double y);

    }
}
