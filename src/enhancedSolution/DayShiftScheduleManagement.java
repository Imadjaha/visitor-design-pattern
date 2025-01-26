package enhancedSolution;

public class DayShiftScheduleManagement implements ScheduleManagement {

    @Override
    public void generateReport() {
        System.out.println(" Generating report for day shift...");
    }

    @Override
    public void calculateOverTime() {
        System.out.println(" Calculating report for day shift...");

    }

    @Override
    public void accept(ScheduleManagementVisitor scheduleManagementVisitor){
        scheduleManagementVisitor.visit(this);
    }

}
