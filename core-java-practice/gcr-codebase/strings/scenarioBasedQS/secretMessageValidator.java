import java.util.Scanner;

public class secretMessageValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the secret code: ");
        String code = scanner.nextLine();
        
        int vowels = 0, consonants = 0, digits = 0, specialChars = 0;
        int length = code.length();
        
        String lowerCaseCode = code.toLowerCase();
        
        for (int i = 0; i < length; i++) {
            char ch = code.charAt(i);
            char lowerCh = lowerCaseCode.charAt(i);
            
            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLetter(ch)) {
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else {
                specialChars++;
            }
        }
        
        boolean isStrong = (digits >= 2) && (specialChars >= 1) && (length >= 8);
        String status = isStrong ? "Strong" : "Weak";
        
        System.out.println("\n--- Detailed Report ---");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialChars);
        System.out.println("Total Length: " + length);
        System.out.println("Code Security Status: " + status);
        
        scanner.close();
    }
}