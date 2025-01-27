package enhancedSolution;

public class RemoteWorkScheduleManagement implements ScheduleManagement {

    @Override
    public void generateReport() {
        System.out.println(" Generating report for remote work shift...");
    }

    @Override
    public void calculateOverTime() {
        System.out.println(" Calculating report for remote work shift...");
    }

@Override
    public void accept(ScheduleManagementVisitor scheduleManagementVisitor){
        scheduleManagementVisitor.visit(this);
}
}
