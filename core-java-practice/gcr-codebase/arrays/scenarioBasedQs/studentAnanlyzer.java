import java.util.ArrayList;
import java.util.Scanner;

public class studentMarksAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> marks = new ArrayList<>();

        System.out.println("--- Student Marks Analyzer ---");
        System.out.println("Enter students' marks (type any non-number letter like 'q' to finish):");

        while (scanner.hasNextDouble()) {
            marks.add(scanner.nextDouble());
        }

        if (marks.isEmpty()) {
            System.out.println("No marks entered. Exiting program.");
            scanner.close();
            return;
        }

        double highest = marks.get(0);
        double lowest = marks.get(0);
        double totalSum = 0;
        int countAbove75 = 0;

        for (double mark : marks) {
            if (mark > highest) highest = mark;
            if (mark < lowest) lowest = mark;
            if (mark > 75) countAbove75++;
            totalSum += mark;
        }

        double average = totalSum / marks.size();

        System.out.println("\n================ RESULTS ================");
        System.out.println("Total Students Tracked: " + marks.size());
        System.out.println("Highest Mark:           " + highest);
        System.out.println("Lowest Mark:            " + lowest);
        System.out.println("Students Scoring > 75:  " + countAbove75);
        System.out.printf("Average Mark:           %.2f\n", average);

        System.out.print("Marks Above Average:    [");
        boolean first = true;
        for (double mark : marks) {
            if (mark > average) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(mark);
                first = false;
            }
        }
        System.out.println("]");
        System.out.println("=========================================");

        scanner.close();
    }
}