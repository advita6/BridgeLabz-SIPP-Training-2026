import java.util.Scanner;

public class AthleteRoundsCalculator {

    // Method to compute the number of rounds needed for a 5km run
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double totalDistanceMeter = 5000; // 5 km = 5000 meters
        return totalDistanceMeter / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();
        
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();
        
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();
        
        double roundsNeeded = calculateRounds(side1, side2, side3);
        
        System.out.printf("The athlete must complete %.2f rounds to finish the 5 km run.%n", roundsNeeded);
        
        scanner.close();
    }
}