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
    private final ConcurrentHashMap<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, SafePoint> points) {
        this.locations = new ConcurrentHashMap<>(points);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    // 发布 实时变化
    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    // 不发布 不实时变化
    public Map<String, SafePoint> getLocationsModify() {
        return Collections.unmodifiableMap(new HashMap<>(locations));
    }

    // 发布
    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void replace(String id, int x, int y) {
        locations.replace(id, new SafePoint(x, y));
    }

    private static class SafePoint {
        public SafePoint(SafePoint p) {
            this.x = p.x;
            this.y = p.y;
        }

        public SafePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private final int x, y;
    }
}
