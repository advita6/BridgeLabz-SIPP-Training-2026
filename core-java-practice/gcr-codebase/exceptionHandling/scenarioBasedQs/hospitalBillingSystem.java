import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    private static final List<String> patients = new ArrayList<>();

    static {
        patients.add("Alice");
        patients.add("Bob");
    }

    public static void processBilling(String indexInput, double totalCost, int itemCount, double paymentAmount) {
        try {
            int index = Integer.parseInt(indexInput);
            String patient = patients.get(index);
            
            double averageItemCost = totalCost / itemCount;
            if (itemCount == 0) {
                throw new ArithmeticException("Division by zero");
            }

            System.out.println("Processing bill for " + patient);
            System.out.println("Average item cost: " + averageItemCost);

            if (paymentAmount < totalCost) {
                throw new InsufficientFundsException("Payment of $" + paymentAmount + " is less than the total bill of $" + totalCost);
            }
            
            System.out.println("Billing completed successfully.");

        } catch (NumberFormatException e) {
            System.err.println("Error: The provided patient index input is not a valid number.");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error: The requested patient index does not exist in the system.");
        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot calculate item averages because the bill has zero items.");
        } catch (InsufficientFundsException e) {
            System.err.println("Transaction Failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Critical Error: An unexpected billing system error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        processBilling("abc", 500.0, 5, 500.0);
        processBilling("5", 500.0, 5, 500.0);
        processBilling("0", 500.0, 0, 500.0);
        processBilling("1", 500.0, 5, 200.0);
        processBilling("1", 500.0, 5, 600.0);
    }
}