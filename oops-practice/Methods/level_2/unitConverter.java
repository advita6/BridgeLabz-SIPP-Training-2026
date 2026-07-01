import java.util.Scanner;

public class UnitConverter {

    // a. Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        double km2miles = 0.621371;
        return km * km2miles;
    }

    // b. Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        double miles2km = 1.60934;
        return miles * miles2km;
    }

    // c. Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }

    // d. Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }

    // Main method to test and demonstrate the functionality of the utility class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter distance in kilometers: ");
        double km = scanner.nextDouble();
        System.out.printf("%.2f km = %.4f miles%n%n", km, convertKmToMiles(km));

        System.out.print("Enter distance in miles: ");
        double miles = scanner.nextDouble();
        System.out.printf("%.2f miles = %.4f km%n%n", miles, convertMilesToKm(miles));

        System.out.print("Enter distance in meters: ");
        double meters = scanner.nextDouble();
        System.out.printf("%.2f meters = %.4f feet%n%n", meters, convertMetersToFeet(meters));

        System.out.print("Enter distance in feet: ");
        double feet = scanner.nextDouble();
        System.out.printf("%.2f feet = %.4f meters%n", feet, convertFeetToMeters(feet));
        
        scanner.close();
    }
}