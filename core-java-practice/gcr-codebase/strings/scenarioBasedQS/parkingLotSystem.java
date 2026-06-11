import java.util.Scanner;

public class ParkingLotSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int MAX_CAPACITY = 5; // Simulating a small parking lot
        int occupiedSpaces = 0;
        boolean running = true;

        System.out.println("=== Smart Parking Lot Gate System ===");

        // Loop continues until lot is full or user exits
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Park a Car");
            System.out.println("2. Exit a Car");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Shutdown System");
            System.out.print("Enter choice: ");

            String choice = scanner.next();

            switch (choice) {
                case "1": // Park
                    if (occupiedSpaces < MAX_CAPACITY) {
                        occupiedSpaces++;
                        System.out.println("Gate Opened. Car parked successfully!");
                        
                        // Check condition to auto-close if full
                        if (occupiedSpaces == MAX_CAPACITY) {
                            System.out.println("🚨 Notice: The parking lot is now FULL.");
                        }
                    } else {
                        System.out.println("Sorry, no spaces available. Parking lot is full!");
                    }
                    break;

                case "2": // Exit
                    if (occupiedSpaces > 0) {
                        occupiedSpaces--;
                        System.out.println("Gate Opened. Car exited successfully.");
                    } else {
                        System.out.println("The parking lot is already empty!");
                    }
                    break;

                case "3": // Show Occupancy
                    System.out.printf("Current Occupancy: %d / %d slots filled.\n", occupiedSpaces, MAX_CAPACITY);
                    break;

                case "4": // Shutdown
                    System.out.println("Shutting down the Parking Gate System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please choose 1, 2, 3, or 4.");
                    break;
            }
        }
        scanner.close();
    }
}