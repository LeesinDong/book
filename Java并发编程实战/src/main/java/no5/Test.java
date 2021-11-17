package no5;

import java.util.*;

/**
 * @author Leesin Dong
 * @since 2021/11/5
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(list1);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        //  vector ???????模拟
        Vector<Integer> vector = new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        for (Integer integer : list) {
            list.remove(integer);
        }

        // Iterator<Integer> iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     Integer next = iterator.next();
        //     iterator.remove();
        // }
        // System.out.println(list);
        //
        // new Thread(() -> {
        //     synchronized (list) {
        //         for (Integer integer : list) {
        //             try {
        //                 Thread.sleep(100);
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // }).start();
        //
        // new Thread(() -> {
        //     list.remove(1);
        //     Iterator<Integer> iterator = list.iterator();
        //     iterator.next();
        //     iterator.remove();
        // }).start();


        new Thread(() -> {
            for (Integer integer : vector) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            // vector.remove(1);
            Iterator<Integer> iterator = vector.iterator();
            iterator.next();
            iterator.remove();
        }).start();
    }
}