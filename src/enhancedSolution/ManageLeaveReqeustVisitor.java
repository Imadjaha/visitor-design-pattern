package enhancedSolution;

public class ManageLeaveReqeustVisitor implements ScheduleManagementVisitor {
    @Override
    public void visit(DayShiftScheduleManagement dayShiftScheduleManagement) {
        System.out.println(" Managing leave requests for day shift...");
    }

    @Override
    public void visit(NightShiftScheduleManagement nightShiftScheduleManagement) {
        System.out.println(" Managing leave requests for night shift...");

    }

    @Override
    public void visit(RemoteWorkScheduleManagement remoteWorkScheduleManagement) {
        System.out.println(" Managing leave requests for remote work shift...");

    }
}
