package no1;

public class Test {

    public static final Test INSTANCE = new Test();

    public Test getInstance() {
        return INSTANCE;
    }
}
