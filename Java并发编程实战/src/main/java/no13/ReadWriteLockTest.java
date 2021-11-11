package no13;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Leesin Dong
 * @since 2021/11/11
 */
public class ReadWriteLockTest<K, V> {
    private final Map<K, V> map;
    private final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private final Lock r = rw.readLock();
    private final Lock w = rw.writeLock();

    public ReadWriteLockTest(Map<K, V> map) {
        this.map = map;
    }

    public void put(K key, V value) {
        w.lock();
        try {
            map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public V get(K key, V value) {
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }
}
