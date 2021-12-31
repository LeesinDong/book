package no22;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public class StateHandler {
    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<>();
    public StateHandler() {
        stateMap.put(Status.Check, new CheckState());
        stateMap.put(Status.Editing, new EditingState());
    }

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }
}
