import java.util.Scanner;
import java.util.Arrays;

public class FactorsAnalyzer {

    // b & c. Static method to find factors and return them as an array
    public static int[] getFactors(int number) {
        // First loop: Find the count of factors to initialize the array
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize the array with the count
        int[] factors = new int[count];

        // Second loop: Save the factors into the array
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }

    // d. Method to find the sum of the factors
    public static int calculateSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // e. Method to find the product of the factors
    public static long calculateProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // f. Method to find the sum of square of the factors using Math.pow()
    public static double calculateSumOfSquares(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            sumOfSquares += Math.pow(factor, 2);
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take input for a number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            int[] factors = getFactors(number);

            // Display results
            System.out.println("The factors are: " + Arrays.toString(factors));
            System.out.println("Sum of factors: " + calculateSum(factors));
            System.out.println("Sum of squares of factors: " + (long)calculateSumOfSquares(factors));
            System.out.println("Product of factors: " + calculateProduct(factors));
        }

        scanner.close();
    }
}