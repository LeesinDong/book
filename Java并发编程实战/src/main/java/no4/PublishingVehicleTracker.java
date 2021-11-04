package no4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leesin Dong
 * @since 2021/11/4
 */
public class PublishingVehicleTracker {
    private final ConcurrentHashMap<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> points) {
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
        // locations.replace(id, new SafePoint(x, y));
        locations.get(id).set(x, y);
    }
}
