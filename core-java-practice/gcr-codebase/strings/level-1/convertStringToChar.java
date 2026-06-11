import java.util.Scanner;

public class convertStringToChar {

    public static char[] convert(String str) {

        char[] arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        char[] result = convert(text);

        for (char ch : result) {
            System.out.print(ch + " ");
        }
    }
}