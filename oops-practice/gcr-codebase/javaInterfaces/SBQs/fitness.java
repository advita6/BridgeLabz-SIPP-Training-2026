import java.util.ArrayList;
import java.util.List;

interface Trackable {
    void logActivity(String activityType, int durationMinutes);

    default void resetData() {
        System.out.println("[Trackable] Default Action: Resetting daily fitness metrics to zero...");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert(String message);
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private final String deviceModel;
    private final List<String> activityLog = new ArrayList<>();
    private int totalMinutesLogged = 0;

    public FitnessDevice(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Override
    public void logActivity(String activityType, int durationMinutes) {
        this.totalMinutesLogged += durationMinutes;
        this.activityLog.add(activityType + " (" + durationMinutes + " mins)");
        System.out.println("[" + deviceModel + "] Logged " + durationMinutes + " mins of " + activityType + ".");
    }

    @Override
    public void generateReport() {
        System.out.println("\n=================================");
        System.out.println("📊 " + deviceModel + " FITNESS REPORT");
        System.out.println("=================================");
        System.out.println("Activities tracked today: " + (activityLog.isEmpty() ? "None" : String.join(", ", activityLog)));
        System.out.println("Total active time:        " + totalMinutesLogged + " minutes");
        System.out.println("=================================\n");
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("🔔 ALERT [" + deviceModel + "]: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        FitnessDevice mySmartWatch = new FitnessDevice("FitPulse Pro v4");

        mySmartWatch.logActivity("Running", 45);
        mySmartWatch.logActivity("Weightlifting", 35);
        mySmartWatch.sendAlert("Goal reached! 10,000 steps completed.");
        mySmartWatch.generateReport();

        mySmartWatch.resetData(); 

        System.out.println("\n--- Polymorphism Demonstration ---");
        Trackable tracker = mySmartWatch;
        Reportable reporter = mySmartWatch;
        Notifiable notifier = mySmartWatch;

        tracker.logActivity("Swimming", 25);
        notifier.sendAlert("System Update Available.");
        
        System.out.println("\nPolymorphic demonstration successful!");
    }
}