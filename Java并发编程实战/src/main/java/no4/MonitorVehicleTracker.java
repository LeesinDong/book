package no4;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Leesin Dong
 * @since 2021/11/3
 */
public class MonitorVehicleTracker {
    private final Map<String, Point> locations;

    public MonitorVehicleTracker(Map<String, Point> locatoins) {
        this.locations = locatoins;
    }

    // 封闭 保证外层状态安全
    public synchronized Map<String, Point> getLocations() {
        return deepCopy(locations);
    }

    public synchronized void setLocations(String id, int x, int y) {
        Point point = locations.get(id);
        Objects.requireNonNull(point, "can not be null!");
        point.x = x;
        point.y = y;
    }

    private static class Point {
        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }

        private int x, y;
    }

    // 不发布 保证内层状态的安全
    private static Map<String, Point> deepCopy(Map<String, Point> map) {
        Map<String, Point> collect = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new Point(entry.getValue())));
        return Collections.unmodifiableMap(collect);
    }
}
