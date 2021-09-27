package no27;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 3:00 下午
 */
public class Test {
    public static void main(String[] args) {
        Object[] o = new Long[1];
        // throw exception when run time
        o[0] = "1";

        // wont compile
        // List<Object> list = new ArrayList<String>();
    }
}
