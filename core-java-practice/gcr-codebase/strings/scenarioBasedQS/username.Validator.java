import java.util.Scanner;

public class usernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        
        boolean hasSpaces = username.contains(" ");
        int charCount = username.length();
        String uppercaseUsername = username.toUpperCase();
        
        String reversed = new StringBuilder(username).reverse().toString();
        boolean isPalindrome = username.equalsIgnoreCase(reversed);
        
        System.out.println("\n--- Validation Results ---");
        System.out.println("Contains spaces: " + (hasSpaces ? "Yes" : "No"));
        System.out.println("Total character count: " + charCount);
        System.out.println("Uppercase version: " + uppercaseUsername);
        System.out.println("Is palindrome: " + (isPalindrome ? "Yes" : "No"));
        
        scanner.close();
    }
}