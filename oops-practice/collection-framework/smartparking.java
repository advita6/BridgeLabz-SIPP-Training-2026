import java.util.ArrayList;

public class SmartParkingManager {
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    // 1. Vehicle Enters
    public void vehicleEnter(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber.toUpperCase())) {
            System.out.println("Vehicle " + registrationNumber + " is already marked as parked inside.");
            return;
        }
        parkedVehicles.add(registrationNumber.toUpperCase());
        System.out.println("Vehicle " + registrationNumber + " entered successfully.");
    }

    // 2. Vehicle Exits
    public void vehicleExit(String registrationNumber) {
        if (parkedVehicles.remove(registrationNumber.toUpperCase())) {
            System.out.println("Vehicle " + registrationNumber + " exited successfully.");
        } else {
            System.out.println("Vehicle " + registrationNumber + " was not found in the parking lot.");
        }
    }

    // 3. Search for a Vehicle
    public void searchVehicle(String registrationNumber) {
        if (parkedVehicles.contains(registrationNumber.toUpperCase())) {
            System.out.println("Vehicle " + registrationNumber + " is currently PARKED.");
        } else {
            System.out.println("Vehicle " + registrationNumber + " is NOT in the parking lot.");
        }
    }

    // 4. Display all Parked Vehicles and Count
    public void displayStatus() {
        System.out.println("\n--- Current Parking Status ---");
        System.out.println("Total Occupied Slots: " + parkedVehicles.size());
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
        } else {
            System.out.println("Parked Vehicle Registration List: " + parkedVehicles);
        }
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        SmartParkingManager mallParking = new SmartParkingManager();

        mallParking.vehicleEnter("DL-1CA-1234");
        mallParking.vehicleEnter("MH-02BD-5678");
        mallParking.vehicleEnter("KA-03EF-9012");

        mallParking.displayStatus();

        mallParking.searchVehicle("MH-02BD-5678");
        
        mallParking.vehicleExit("MH-02BD-5678");
        
        mallParking.displayStatus();
    }
}