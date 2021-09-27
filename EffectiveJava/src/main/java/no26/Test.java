package no26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/27 11:21 上午
 */
public class Test {
    public static void main(String[] args) {
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

    private static void unsafeAdd(List<String> a, Object valueOf) {
        // a.add(valueOf);
    }
}
