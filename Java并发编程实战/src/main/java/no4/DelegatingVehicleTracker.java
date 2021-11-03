package no4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leesin Dong
 * @since 2021/11/3
 */
public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        this.locations = new ConcurrentHashMap<>(points);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    // 发布 实时变化
    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    // 不发布 不实时变化
    public Map<String, Point> getLocationsModify() {
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    // 发布
    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void replace(String id, int x, int y) {
        locations.replace(id, new Point(x, y));
    }

    private static class Point {
        public Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private final int x, y;
    }
}
