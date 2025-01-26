package enhancedSolution;

public interface ScheduleManagement {
    void generateReport();
    void calculateOverTime();
    void accept(ScheduleManagementVisitor scheduleManagementVisitor);
}
