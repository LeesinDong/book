package no5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Leesin Dong
 * @since 2021/11/16
 */
public class IteratorConcurrentTest {

    private final List<Integer> list = new ArrayList<>();

    @Test
    public void test() {
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(2);
        // for (Integer i : copyOnWriteArrayList) {
        //     if (i == 2) {
        //         copyOnWriteArrayList.remove(i);
        //     }
        // }
        // copyOnWriteArrayList.forEach(System.out::println);
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            if (copyOnWriteArrayList.get(i) == 2) {
                copyOnWriteArrayList.remove(copyOnWriteArrayList.get(i));
            }
        }

    }

    @Test
    public void testFor() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        // ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("b")) {
                list.remove(s);
            }
        }

        list.removeIf(i -> i.equals("b"));
        System.out.println(list);
    }

    @Test
    public void test1() {
        // 必须添加够一定的数量才会报错
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(list.get(i));
            }
        }
        // for (Integer integer : list) {
        //     if (integer == 2) {
        //         list.remove(integer);
        //     }
        // }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++)
            list.add(i);
        // list {0, 1, 2, 3, 4}
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            // index and number
            int num = it.next();
            System.out.print(num);
            if (num % 2 == 0) {
                it.remove();
                System.out.print(" delete");
            }
            System.out.println();
        }
    }
}
