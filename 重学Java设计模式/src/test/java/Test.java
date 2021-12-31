import no22.ActivityService;
import no22.Result;
import no22.StateHandler;
import no22.Status;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */
public class Test {

    @org.junit.Test
    public void test() {
        // String activityId = "1001";
        // ActivityService.init(activityId, Status.Editing);
        // StateHandler stateHandler = new StateHandler();
        // Result arraignment = stateHandler.arraignment(activityId, Status.Editing);
        // System.out.println(arraignment.toString());

        System.out.println();

        String activityId2 = "1002";
        ActivityService.init(activityId2, Status.Check);
        StateHandler stateHandler2 = new StateHandler();
        Result arraignment2 = stateHandler2.checkPass(activityId2, Status.Check);
        System.out.println(arraignment2.toString());
    }
}
