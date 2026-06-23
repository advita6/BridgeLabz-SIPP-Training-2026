class Vehicle {
    // Instance variables
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType; // "Car" or "Bike"

    // Constructor using 'this'
    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Getter for vehicle type to perform safe structural filtering
    public String getVehicleType() {
        return this.vehicleType;
    }

    public void displayDetails() {
        System.out.println("Number: " + this.vehicleNumber + " | Owner: " + this.ownerName);
    }
}

public class MainParkingSystem {
    
    // Method to display Cars
    public static void displayCars(Vehicle[] parkingLot) {
        System.out.println("\n--- List of Parked Cars ---");
        boolean found = false;
        for (Vehicle v : parkingLot) {
            if (v != null && v.getVehicleType().equalsIgnoreCase("Car")) {
                v.displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No cars parked currently.");
    }

    // Method to display Bikes
    public static void displayBikes(Vehicle[] parkingLot) {
        System.out.println("\n--- List of Parked Bikes ---");
        boolean found = false;
        for (Vehicle v : parkingLot) {
            if (v != null && v.getVehicleType().equalsIgnoreCase("Bike")) {
                v.displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No bikes parked currently.");
    }

    public static void main(String[] args) {
        // Initializing array storing up to 10 vehicles
        Vehicle[] parkingLot = new Vehicle;

        // Seeding the array with 10 sample vehicles (mix of Cars and Bikes)
        parkingLot = new Vehicle("MH-12-AB-1234", "John Doe", "Car");
        parkingLot = new Vehicle("DL-3C-XY-5678", "Jane Smith", "Bike");
        parkingLot = new Vehicle("KA-03-MN-9999", "Alex Carey", "Car");
        parkingLot = new Vehicle("MH-14-CC-1111", "Sarah Connor", "Bike");
        parkingLot = new Vehicle("TX-88-ZZ-4321", "Bruce Wayne", "Car");
        parkingLot = new Vehicle("NY-11-GG-7777", "Peter Parker", "Bike");
        parkingLot = new Vehicle("CA-55-LL-0000", "Tony Stark", "Car");
        parkingLot = new Vehicle("HR-26-BR-2222", "Clark Kent", "Car");
        parkingLot = new Vehicle("GJ-01-AA-5555", "Barry Allen", "Bike");
        parkingLot = new Vehicle("KA-51-HE-8888", "Diana Prince", "Car");

        // Executing filtering methods
        displayCars(parkingLot);
        displayBikes(parkingLot);
    }
}