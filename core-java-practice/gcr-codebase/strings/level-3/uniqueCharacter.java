import java.util.Scanner;

public class uniqueCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            boolean printed = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    printed = true;
                    break;
                }
            }

            if (!printed) {
                System.out.println(ch + " -> " + freq[ch]);
            }
        }
    }
}