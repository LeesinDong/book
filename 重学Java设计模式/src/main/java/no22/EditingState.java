package no22;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public class EditingState extends State {
    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "活动审批成功");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("00001", "编辑中欧冠不可审批通过");
    }
}
