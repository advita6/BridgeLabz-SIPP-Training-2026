import java.util.Scanner;

public class HandshakeCalculator {

    // Method to calculate the number of handshakes
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        int totalHandshakes = calculateHandshakes(numberOfStudents);
        
        System.out.println("The maximum number of possible handshakes is: " + totalHandshakes);
        
        scanner.close();
    }
}