import java.util.ArrayList;
import java.util.Scanner;

public class CinemaSeatAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> seats = new ArrayList<>();

        System.out.println("--- Cinema Seat Analyzer ---");
        System.out.println("Enter seat arrangement (0 for Empty, 1 for Booked. Type 'q' to analyze):");

        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input == 0 || input == 1) {
                seats.add(input);
            } else {
                System.out.println("Invalid input ignored. Please enter 0 or 1.");
            }
        }

        if (seats.isEmpty()) {
            System.out.println("No seat data entered. Exiting program.");
            scanner.close();
            return;
        }

        int bookedCount = 0;
        int availableCount = 0;

        int currentStart = -1;
        int currentLength = 0;

        int bestStart = -1;
        int bestEnd = -1;
        int maxLength = 0;

        for (int i = 0; i < seats.size(); i++) {
            int seat = seats.get(i);

            if (seat == 1) {
                bookedCount++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    bestStart = currentStart;
                    bestEnd = i - 1;
                }
                currentLength = 0;
                currentStart = -1;
            } else {
                availableCount++;
                if (currentLength == 0) {
                    currentStart = i;
                }
                currentLength++;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            bestStart = currentStart;
            bestEnd = seats.size() - 1;
        }

        System.out.println("\n================ CINEMA ANALYSIS ================");
        System.out.println("Total Booked Seats:    " + bookedCount);
        System.out.println("Total Available Seats: " + availableCount);
        System.out.println("-------------------------------------------------");

        if (maxLength > 0) {
            System.out.println("Longest Continuous Empty Block: " + maxLength + " seats");
            System.out.println("Starting Position (Index):      " + bestStart);
            System.out.println("Ending Position (Index):        " + bestEnd);
        } else {
            System.out.println("Longest Continuous Empty Block: 0 seats");
            System.out.println("No empty blocks found.");
        }
        System.out.println("-------------------------------------------------");

        System.out.print("Group Seating Suggestion (5 People): ");
        if (maxLength >= 5) {
            System.out.println("YES, a group of 5 can sit together between indexes " + bestStart + " and " + bestEnd + ".");
        } else {
            System.out.println("NO, a group of 5 cannot sit together consecutively.");
        }
        System.out.println("=================================================");

        scanner.close();
    }
}