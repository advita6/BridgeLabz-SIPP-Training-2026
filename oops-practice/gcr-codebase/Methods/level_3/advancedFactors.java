import java.util.Scanner;
import java.util.Arrays;

public class AdvancedFactorsManager {

    // 7.a: Method to isolate factors into an exact size array (Two Loop Approach)
    public static int[] extractFactors(int number) {
        // Loop 1: Find count size
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];

        // Loop 2: Record structural values
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // 7.b: Method to grab the largest explicit factor
    public static int getGreatestFactor(int[] factors) {
        if (factors.length == 0) return 0;
        int max = factors[0];
        for (int factor : factors) {
            if (factor > max) {
                max = factor;
            }
        }
        return max;
    }

    // 7.c: Method to calculate factor structural sum
    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // 7.d: Method to calculate total linear multiplication product
    public static long productFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // 7.e: Method to evaluate cumulative multiplication of cubed items
    public static double productOfCubes(int[] factors) {
        double totalProduct = 1.0;
        for (int factor : factors) {
            totalProduct *= Math.pow(factor, 3);
        }
        return totalProduct;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to isolate structural factors: ");
        int num = scanner.nextInt();

        if (num <= 0) {
            System.out.println("Please provide a valid positive index value.");
        } else {
            int[] factorsArr = extractFactors(num);

            System.out.println("\n--- Factors Structural Matrix Results ---");
            System.out.println("Identified Factors List: " + Arrays.toString(factorsArr));
            System.out.println("Greatest Factor Found: " + getGreatestFactor(factorsArr));
            System.out.println("Sum Total of Factors: " + sumFactors(factorsArr));
            System.out.println("Linear Product of Factors: " + productFactors(factorsArr));
            System.out.printf("Cumulative Product of Cubed Factors: %.0f%n", productOfCubes(factorsArr));
        }
        scanner.close();
    }
}