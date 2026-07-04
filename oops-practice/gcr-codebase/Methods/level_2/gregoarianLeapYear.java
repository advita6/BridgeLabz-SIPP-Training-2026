import java.util.Scanner;

public class LeapYearChecker {

    // c. Method to check for Leap Year using conditions a and b
    public static boolean isLeapYear(int year) {
        // a. Only works for year >= 1582
        if (year < 1582) {
            return false;
        }
        
        // b. Divisible by 4 and not divisible by 100, OR divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("The validation only applies to the Gregorian calendar (Year 1582 onwards).");
        } else {
            if (isLeapYear(year)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        }

        scanner.close();
    }
}