package no26;

import java.util.*;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 11:21 上午
 */
public class Test<E> {
    public static  void main(String[] args) {
        List<String> list = new ArrayList<>();
        unsafeAdd(list, Integer.valueOf(2));
        System.out.println(list);
        String s = list.get(0);

        @SuppressWarnings("unchecked")
        Set<String> set = new HashSet();


        if (list instanceof List) {
            List<?> list1 = (List<?>)list;
        }


    }

    public void test() {
        List<String> c = new ArrayList<>();
        // List<?> c = new ArrayList<>();
        c.add("");
        // List<String> l = new ArrayList<>();
        // l.add("");
    }

    private static void unsafeAdd(List<String> a, Object valueOf) {
        // a.add(valueOf);
    }
}
