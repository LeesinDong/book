package no22;

import java.util.List;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/26 10:40 下午
 */
public class Test {
    private Test() {
    }

    ;

    public static final String CONST_TEST = "const test";
    public static final String CONST_TEST1 = "const test1";
    public static final String CONST_TEST2 = "const test1";

    // will warn
    // List<String>[] s = new List<String>[1];

    Object a = new Object();
    String s = (String)a;

}


