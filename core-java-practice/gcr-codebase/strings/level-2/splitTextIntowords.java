import java.util.Scanner;

public class splitTextIntoWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] words = text.split(" ");

        for (String word : words) {
            System.out.println(word);
        }
    }
}