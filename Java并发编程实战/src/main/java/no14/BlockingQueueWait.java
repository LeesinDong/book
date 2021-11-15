package no14;

import java.util.ArrayList;

/**
 * @author Leesin Dong
 * @since 2021/11/12
 */
public class BlockingQueueWait {
    private boolean isFull;
    private boolean isEmpty;
    private ArrayList list;

    public synchronized void put(int i) throws InterruptedException {
        while (isFull) {
            wait();
        }

        list.add(1);
        if (isEmpty) {
            notifyAll();
        }
    }

    public synchronized void get(int i) throws InterruptedException {
        while (isEmpty) {
            wait();
        }

        list.remove(i);
        if (isFull) {
            notifyAll();
        }
    }
}
