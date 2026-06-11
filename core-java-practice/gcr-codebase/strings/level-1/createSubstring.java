import java.util.Scanner;

public class createSubstring {

    public static String mySubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        System.out.println(mySubstring(text, start, end));
        System.out.println(text.substring(start, end));
    }
}