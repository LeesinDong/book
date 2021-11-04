package no4;

/**
 * @author Leesin Dong
 * @since 2021/11/4
 */
public class SafePoint {
    private int x, y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SafePoint(SafePoint p) {
        p.get();
    }

    private SafePoint(int[] array) {
        this(array[0], array[1]);
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
