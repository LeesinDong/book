package no4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Leesin Dong
 * @since 2021/11/4
 */
public class VisualComponent {
    private final List<String> keys = new CopyOnWriteArrayList<>();
    private final List<String> values = new CopyOnWriteArrayList<>();

    public void addKey(String key) {
        keys.add(key);
    }

    public void addValue(String key) {
        values.add(key);
    }

    public void removeKey(String key) {
        keys.remove(key);
    }

    public void removeValue(String value) {
        values.remove(value);
    }
}
