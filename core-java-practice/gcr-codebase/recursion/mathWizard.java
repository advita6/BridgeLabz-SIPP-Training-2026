import java.util.Scanner;

public class mathWizard {

    // Instance Variable
    int wizardId = 101;

    // Recursive Prime Check
    public boolean isPrime(int n) {

        if (n <= 1)
            return false;

        return checkPrime(n, 2);
    }

    private boolean checkPrime(int n, int divisor) {

        if (divisor * divisor > n)
            return true;

        if (n % divisor == 0)
            return false;

        return checkPrime(n, divisor + 1);
    }

    // Recursive Factorial (int)
    public int factorial(int n) {

        if (n <= 1)
            return 1;

        return n * factorial(n - 1);
    }

    // Overloaded Recursive Factorial (double)
    public double factorial(double n) {

        if (n <= 1.0)
            return 1.0;

        return n * factorial(n - 1);
    }

    // Recursive Fibonacci
    public int fibonacci(int n) {

        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Recursive GCD
    public int gcd(int a, int b) {

        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    // LCM using GCD
    public int lcm(int a, int b) {

        return (a * b) / gcd(a, b);
    }

    // Recursive Power
    public long power(int base, int exp) {

        if (exp == 0)
            return 1;

        return base * power(base, exp - 1);
    }

    // Scope Demonstration
    public void showScope() {

        // Local Variable
        int wizardId = 999;

        System.out.println("Local Variable = " + wizardId);

        System.out.println("Instance Variable = " + this.wizardId);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MathWizard obj = new MathWizard();

        System.out.print("Enter number for prime check: ");
        int num = sc.nextInt();

        System.out.println("Is Prime? " + obj.isPrime(num));

        System.out.print("\nEnter integer for factorial: ");
        int factNum = sc.nextInt();

        System.out.println("Factorial = " + obj.factorial(factNum));

        System.out.print("\nEnter double for factorial: ");
        double doubleNum = sc.nextDouble();

        System.out.println("Double Factorial = " +
                obj.factorial(doubleNum));

        System.out.print("\nEnter fibonacci position: ");
        int fib = sc.nextInt();

        System.out.println("Fibonacci = " + obj.fibonacci(fib));

        System.out.print("\nEnter two numbers for GCD & LCM: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD = " + obj.gcd(a, b));
        System.out.println("LCM = " + obj.lcm(a, b));

        System.out.print("\nEnter base and exponent: ");
        int base = sc.nextInt();
        int exp = sc.nextInt();

        System.out.println("Power = " + obj.power(base, exp));

        System.out.println("\nScope Demonstration:");
        obj.showScope();

        sc.close();
    }
}