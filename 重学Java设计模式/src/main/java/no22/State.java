package no22;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public abstract class State {
    public abstract Result arraignment(String activityId, Enum<Status> currentStatus);

    public abstract Result checkPass(String activityId, Enum<Status> currentStatus);
}
