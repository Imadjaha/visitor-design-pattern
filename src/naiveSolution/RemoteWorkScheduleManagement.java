package naiveSolution;

public class RemoteWorkScheduleManagement implements ScheduleManagement{

    @Override
    public void generateReport() {
        System.out.println(" Generating report for remote work shift...");
    }

    @Override
    public void calculateOverTime() {
        System.out.println(" Calculating report for remote work shift...");

    }

    @Override
    public void manageLeaveRequets() {
        System.out.println(" Managing leave requests for remote work shift...");

    }
}
