public class Vehicle {
    // 1. Static variable common to all vehicles
    private static double registrationFee = 50.0;

    // 3. Final variable ensuring a unique, unalterable identifier per vehicle
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    // Constructor
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        // 2. Use 'this' to resolve ambiguity between parameters and instance fields
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // 1. Static method to modify the registration fee globally for all vehicles
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display registration details
    public void displayRegistrationDetails() {
        System.out.println("--- Official Vehicle Registration ---");
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Registered Owner  : " + this.ownerName);
        System.out.println("Vehicle Type      : " + this.vehicleType);
        System.out.println("Flat Registration Fee : $" + registrationFee);
        System.out.println("-------------------------------------");
    }
}