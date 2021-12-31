package no22;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public class CheckState extends State{
    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("00001", "待审批状态不可重复提审");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Pass);
        return new Result("0000", "活动审批通过完成");
    }
}
