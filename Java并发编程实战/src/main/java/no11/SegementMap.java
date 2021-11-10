package no11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Leesin Dong
 * @since 2021/11/10
 */
public class SegementMap {
    // 分而治之
    private final int lockNum = 16;
    private final Node[] nodes;
    private final Object[] locks;

    public SegementMap(int n) {
        nodes = new Node[n];
        locks = new Object[lockNum];
        for (Object lock : locks) {
            lock = new Object();
        }
    }

    public int getPlace(Object key) {
        return Math.abs(key.hashCode() % nodes.length);
    }

    public Node getNode(Object key) {
        int place = getPlace(key);
        synchronized (locks[place % lockNum]) {
            for (Node node = nodes[place]; node != null; node = node.next) {
                if (node.getKey().equals(key)) {
                    return node;
                }
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < nodes.length; i++) {
            synchronized (locks[i % lockNum]) {
                nodes[i] = null;
            }
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    private class Node {
        private Node next;
        private Object key;
        private Object value;
    }
}
