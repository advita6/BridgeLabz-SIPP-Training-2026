import java.util.Scanner;
import java.util.Arrays;

public class NumberChecker {

    // ==========================================
    // TASK 4 METHODS (Digits & Arrays)
    // ==========================================

    // 4.a (Part 1): Method to count digits
    public static int getDigitCount(int number) {
        if (number == 0) return 1;
        int count = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // 4.a (Part 2): Method to store digits in an array
    public static int[] getDigitsArray(int number) {
        int count = getDigitCount(number);
        int[] digits = new int[count];
        int temp = Math.abs(number);
        
        // Populating from end to start to match reading order
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    // 4.b: Method to reverse a digits array
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    // 4.c: Method to compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    // 4.d: Method to check Palindrome using digits
    public static boolean isPalindrome(int number) {
        int[] original = getDigitsArray(number);
        int[] reversed = reverseArray(original);
        return areArraysEqual(original, reversed);
    }

    // 4.e: Method to check Duck Number using digits array
    // A duck number has a zero in it but does NOT start with a zero.
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        if (digits.length > 0 && digits[0] == 0) return false; 
        
        for (int digit : digits) {
            if (digit == 0) return true;
        }
        return false;
    }

    // ==========================================
    // TASK 5 METHODS (Special Mathematical Numbers)
    // ==========================================

    // 5.a: Method to check Prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // 5.b: Method to check Neon Number
    public static boolean isNeonNumber(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    // 5.c: Method to check Spy Number
    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = Math.abs(number);
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // 5.d: Method to check Automorphic Number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        int temp = number;
        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    // 5.e: Method to check Buzz Number
    public static boolean isBuzzNumber(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }

    // ==========================================
    // TASK 6 METHODS (Divisors & Factorials)
    // ==========================================

    // Helper method to compute sum of proper divisors
    private static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // 6.a: Method to check Perfect Number
    public static boolean isPerfectNumber(int number) {
        if (number <= 0) return false;
        return sumOfProperDivisors(number) == number;
    }

    // 6.b: Method to check Abundant Number
    public static boolean isAbundantNumber(int number) {
        if (number <= 0) return false;
        return sumOfProperDivisors(number) > number;
    }

    // 6.c: Method to check Deficient Number
    public static boolean isDeficientNumber(int number) {
        if (number <= 0) return false;
        return sumOfProperDivisors(number) < number;
    }

    // Helper method for factorial calculation
    private static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // 6.d: Method to check Strong Number
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == number;
    }

    // ==========================================
    // MAIN METHOD TO EXECUTE ALL TASKS
    // ==========================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to pass through the evaluation checks: ");
        int inputNum = scanner.nextInt();

        System.out.println("\n--- Evaluation Reports for: " + inputNum + " ---");

        // Execution of Task 4 Checks
        int[] originalDigits = getDigitsArray(inputNum);
        int[] reversedDigits = reverseArray(originalDigits);
        System.out.println("[T4] Total Digit Count: " + getDigitCount(inputNum));
        System.out.println("[T4] Digits Array: " + Arrays.toString(originalDigits));
        System.out.println("[T4] Reversed Digits Array: " + Arrays.toString(reversedDigits));
        System.out.println("[T4] Is Palindrome? " + isPalindrome(inputNum));
        System.out.println("[T4] Is Duck Number? " + isDuckNumber(inputNum));

        // Execution of Task 5 Checks
        System.out.println("[T5] Is Prime Number? " + isPrime(inputNum));
        System.out.println("[T5] Is Neon Number? " + isNeonNumber(inputNum));
        System.out.println("[T5] Is Spy Number? " + isSpyNumber(inputNum));
        System.out.println("[T5] Is Automorphic? " + isAutomorphic(inputNum));
        System.out.println("[T5] Is Buzz Number? " + isBuzzNumber(inputNum));

        // Execution of Task 6 Checks
        System.out.println("[T6] Is Perfect Number? " + isPerfectNumber(inputNum));
        System.out.println("[T6] Is Abundant Number? " + isAbundantNumber(inputNum));
        System.out.println("[T6] Is Deficient Number? " + isDeficientNumber(inputNum));
        System.out.println("[T6] Is Strong Number? " + isStrongNumber(inputNum));

        scanner.close();
    }
}