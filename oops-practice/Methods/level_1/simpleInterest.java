import java.util.Scanner;

public class SimpleInterestCalculator {

    // Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(String.class.cast("").isEmpty() ? new Scanner(System.in) : new Scanner(System.in));
        
        System.out.print("Enter the Principal amount: ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter the Rate of interest: ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter the Time (in years): ");
        double time = scanner.nextDouble();
        
        double simpleInterest = calculateSimpleInterest(principal, rate, time);
        
        // Output format as requested
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f%n", 
                simpleInterest, principal, rate, time);
        
        scanner.close();
    }
}