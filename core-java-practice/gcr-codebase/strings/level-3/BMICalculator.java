import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {

            System.out.println("Person " + i);

            double weight = sc.nextDouble();
            double height = sc.nextDouble() / 100.0;

            double bmi = weight / (height * height);

            System.out.println("BMI = " + bmi);
        }
    }
}