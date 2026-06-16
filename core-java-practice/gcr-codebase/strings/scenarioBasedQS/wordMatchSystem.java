import java.util.Arrays;
import java.util.Scanner;

public class wordMatchSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first keyword: ");
        String word1 = scanner.nextLine();
        
        System.out.print("Enter second keyword: ");
        String word2 = scanner.nextLine();
        
        String cleanWord1 = word1.replaceAll("\\s+", "").toLowerCase();
        String cleanWord2 = word2.replaceAll("\\s+", "").toLowerCase();
        
        boolean isAnagram = false;
        
        if (cleanWord1.length() == cleanWord2.length()) {
            char[] array1 = cleanWord1.toCharArray();
            char[] array2 = cleanWord2.toCharArray();
            
            Arrays.sort(array1);
            Arrays.sort(array2);
            
            isAnagram = Arrays.equals(array1, array2);
        }
        
        System.out.println("\n--- Skill Match Report ---");
        System.out.println("First Keyword (Uppercase): " + word1.toUpperCase());
        System.out.println("Length: " + word1.length());
        System.out.println("Second Keyword (Uppercase): " + word2.toUpperCase());
        System.out.println("Length: " + word2.length());
        
        if (isAnagram) {
            System.out.println("Result: The keywords are anagrams! They represent a perfect skill match.");
        } else {
            System.out.println("Result: The keywords are not anagrams. They represent different skills.");
        }
        
        scanner.close();
    }
}