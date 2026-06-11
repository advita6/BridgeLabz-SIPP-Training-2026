import java.util.Scanner;

public class ResultGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalMarks = 0;
        int totalSubjects = 5;

        System.out.println("--- Raj's Coaching Center Result Generator ---");

        // Loop to iterate over 5 subjects
        for (int i = 1; i <= totalSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + i + " (out of 100): ");
                if (scanner.hasNextDouble()) {
                    double marks = scanner.nextDouble();
                    if (marks >= 0 && marks <= 100) {
                        totalMarks += marks;
                        break; // Valid input, break inner loop
                    }
                } else {
                    scanner.next(); // Clear invalid input
                }
                System.out.println("Invalid input. Please enter marks between 0 and 100.");
            }
        }

        // Calculate average
        double average = totalMarks / totalSubjects;
        
        // Convert average to a base scale for the switch case (dividing by 10)
        int scoreKey = (int) average / 10;
        String grade;

        // Switch to assign grades
        switch (scoreKey) {
            case 10, 9 -> grade = "A (Excellent)";
            case 8    -> grade = "B (Very Good)";
            case 7    -> grade = "C (Good)";
            case 6    -> grade = "D (Pass)";
            default   -> grade = "F (Fail)";
        }

        // Output formatting
        System.out.println("\n=======================");
        System.out.printf("Total Marks: %.2f / %d\n", totalMarks, (totalSubjects * 100));
        System.out.printf("Average Marks: %.2f%%\n", average);
        System.out.println("Final Grade: " + grade);
        System.out.println("=======================");

        scanner.close();
    }
}