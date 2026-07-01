import java.util.Scanner;

public class NaturalNumberSum {

    // b. Method to find the sum of n natural numbers using recursion
    public static int sumRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumRecursive(n - 1);
    }

    // c. Method to find the sum of n natural numbers using the formula n*(n+1)/2
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take user input and check whether it's a Natural number
        System.out.print("Enter a number (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Error: The number must be a natural number (greater than 0).");
        } else {
            int recursiveResult = sumRecursive(n);
            int formulaResult = sumFormula(n);

            // d. Compare the two results and print the verification
            System.out.println("Sum using Recursion: " + recursiveResult);
            System.out.println("Sum using Formula: " + formulaResult);

            if (recursiveResult == formulaResult) {
                System.out.println("Success: Both computations yield identical and correct results!");
            } else {
                System.out.println("Mismatch found.");
            }
        }

        scanner.close();
    }
}