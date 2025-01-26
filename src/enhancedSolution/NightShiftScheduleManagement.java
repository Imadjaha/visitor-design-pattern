package enhancedSolution;

public class NightShiftScheduleManagement implements ScheduleManagement {

    @Override
    public void generateReport() {
        System.out.println(" Generating report for night shift...");
    }

    @Override
    public void calculateOverTime() {
        System.out.println(" Calculating report for night shift...");

    }

    @Override
    public void accept(ScheduleManagementVisitor scheduleManagementVisitor){
        scheduleManagementVisitor.visit(this);
    }


}
