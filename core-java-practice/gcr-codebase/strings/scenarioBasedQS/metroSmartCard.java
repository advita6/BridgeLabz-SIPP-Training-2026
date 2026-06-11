import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initializing a starting balance
        double balance = 500.0; 
        System.out.println("Welcome to Delhi Metro Smart Card System!");
        System.out.printf("Current Balance: ₹%.2f\n", balance);

        while (balance > 0) {
            System.out.print("\nEnter travel distance in km (or type 'quit' to exit): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for traveling with Delhi Metro!");
                break;
            }

            try {
                double distance = Double.parseDouble(input);
                if (distance < 0) {
                    System.out.println("Distance cannot be negative. Try again.");
                    continue;
                }

                // Fare Logic using Ternary Operator: 
                // Short distance (<= 5km) = ₹20, Medium (<= 15km) = ₹40, Long (> 15km) = ₹60
                double fare = (distance <= 5) ? 20.0 : (distance <= 15) ? 40.0 : 60.0;

                System.out.printf("Calculated Fare: ₹%.2f\n", fare);

                if (balance >= fare) {
                    balance -= fare;
                    System.out.printf("Trip successful! Remaining Balance: ₹%.2f\n", balance);
                } else {
                    System.out.printf("Insufficient balance! Required: ₹%.2f, Available: ₹%.2f\n", fare, balance);
                    System.out.println("Please top up your card.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid distance or 'quit'.");
            }
        }

        if (balance <= 0) {
            System.out.println("\nYour card balance is exhausted. Please recharge!");
        }
        scanner.close();
    }
}