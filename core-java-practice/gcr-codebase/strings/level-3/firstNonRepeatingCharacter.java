import java.util.Scanner;

public class firstNonRepeatingCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        for (int i = 0; i < text.length(); i++) {

            int count = 0;

            for (int j = 0; j < text.length(); j++) {

                if (text.charAt(i) == text.charAt(j))
                    count++;
            }

            if (count == 1) {
                System.out.println(text.charAt(i));
                break;
            }
        }
    }
}