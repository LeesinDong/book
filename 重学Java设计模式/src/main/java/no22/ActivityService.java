package no22;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public class ActivityService {
    private final static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(String activityId, Enum<Status> status) {
        ActivityInfo activityInfo = new ActivityInfo();
        statusMap.put(activityId, status);
    }

    public static ActivityInfo queryActivityInfo(String activityId) {
        ActivityInfo activityInfo = new ActivityInfo();
        return activityInfo;

    }

    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus,
                                               Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) {
            return;
        }

        statusMap.put(activityId, afterStatus);
    }
}
