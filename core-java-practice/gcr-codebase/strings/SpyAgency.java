//A spy agency encodes messages. Reverse a secret message, check if it is a palindrome, count vowels/consonants, and verify if two intercepts are anagrams. Extend: find the first non-repeating character in a surveillance log.

import java.util.Scanner;

public class SpyAgency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Secret Message
        System.out.print("Enter Secret Message: ");
        String message = sc.nextLine().toLowerCase();

        // Reverse String
        String reversed = "";

        for (int i = message.length() - 1; i >= 0; i--) {
            reversed += message.charAt(i);
        }

        System.out.println("\nReversed Message: " + reversed);

        // Palindrome Check
        if (message.equals(reversed)) {
            System.out.println("Message is a Palindrome");
        } else {
            System.out.println("Message is NOT a Palindrome");
        }

        // Count Vowels and Consonants
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < message.length(); i++) {

            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {

                if (ch == 'a' || ch == 'e' || ch == 'i'
                        || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        // Anagram Check
        System.out.print("\nEnter First Intercept: ");
        String intercept1 = sc.next().toLowerCase();

        System.out.print("Enter Second Intercept: ");
        String intercept2 = sc.next().toLowerCase();

        if (isAnagram(intercept1, intercept2)) {
            System.out.println("Intercepts are Anagrams");
        } else {
            System.out.println("Intercepts are NOT Anagrams");
        }

        // First Non-Repeating Character
        System.out.print("\nEnter Surveillance Log: ");
        String log = sc.next().toLowerCase();

        char result = firstNonRepeating(log);

        if (result != '\0') {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        sc.close();
    }

    // Anagram Method
    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    // First Non-Repeating Character
    public static char firstNonRepeating(String str) {

        for (int i = 0; i < str.length(); i++) {

            boolean unique = true;

            for (int j = 0; j < str.length(); j++) {

                if (i != j && str.charAt(i) == str.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique)
                return str.charAt(i);
        }

        return '\0';
    }
}