class Drone {
    // Static variable shared across all instances
    public static String companyName = "Global Logistics Drones Inc.";

    // Instance variables
    private String droneId;
    private int batteryPercentage;

    // Constructor using 'this' keyword
    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    // Methods
    public void startDelivery() {
        if (this.batteryPercentage >= 20) {
            System.out.println("Drone " + this.droneId + " is taking off for delivery.");
            this.batteryPercentage -= 15; // Simulating battery drain post-delivery
        } else {
            System.out.println("Drone " + this.droneId + " cannot deliver. Battery too low (" + this.batteryPercentage + "%). Please charge!");
        }
    }

    public void displayStatus() {
        System.out.println("Drone ID: " + this.droneId + 
                           " | Battery: " + this.batteryPercentage + "%" + 
                           " | Company: " + Drone.companyName); // Accessing static variable cleanly
    }
}

public class MainDroneSystem {
    public static void main(String[] args) {
        // Creating multiple drones
        Drone droneA = new Drone("DRONE-Alpha", 85);
        Drone droneB = new Drone("DRONE-Beta", 15);
        Drone droneC = new Drone("DRONE-Gamma", 50);

        System.out.println("=== Initial Drone Statuses ===");
        droneA.displayStatus();
        droneB.displayStatus();
        droneC.displayStatus();
        
        System.out.println("\n=== Verifying Static/Shared Company Name ===");
        // Modifying via class level updates it for all instances seamlessly
        System.out.println("Drone A Company: " + droneA.companyName);
        System.out.println("Drone B Company: " + droneB.companyName);
        System.out.println("Drone C Company: " + droneC.companyName);

        System.out.println("\n=== Running Deliveries ===");
        droneA.startDelivery();
        droneB.startDelivery(); 
        droneC.startDelivery();
    }
}