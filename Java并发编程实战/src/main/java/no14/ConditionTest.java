package no14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Leesin Dong
 * @since 2021/11/12
 */
public class ConditionTest {
    ReentrantLock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private boolean isFull;
    private boolean isEmpty;
    List<Integer> list = new ArrayList<>();
    
    public void put() throws InterruptedException {
        lock.wait();
        try {
            while (isFull) {
                full.await();
            }
            list.add(1);
            if (!isEmpty) {
                empty.signal();
            }
        }finally {
            lock.unlock();
        }
    }
    
    public void get() throws InterruptedException {
        lock.wait();
        try {
            while (isEmpty) {
                empty.await();
            }
            list.remove(1);
            if (!isFull) {
                full.signal();
            }
        }finally {
            lock.unlock();
        }
    } 
}
