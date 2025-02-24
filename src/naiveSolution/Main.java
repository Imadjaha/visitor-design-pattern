package naiveSolution;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ScheduleManagement> scheduleManagementList = List.of(new DayShiftScheduleManagement(),
                new NightShiftScheduleManagement(), new RemoteWorkScheduleManagement());

        scheduleManagementList.forEach(scheduleManagement -> {
            scheduleManagement.generateReport();
            scheduleManagement.calculateOverTime();
            scheduleManagement.manageLeaveRequets();
        });
    }
}