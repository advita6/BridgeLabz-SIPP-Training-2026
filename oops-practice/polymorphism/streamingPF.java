abstract class Subscription {

    String subscriberName;
    String subscriptionId;

    Subscription(String name, String id) {
        subscriberName = name;
        subscriptionId = id;
    }

    abstract double calculateMonthlyCharge();
}

class BasicPlan extends Subscription {

    BasicPlan(String n, String i) {
        super(n, i);
    }

    double calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends Subscription {

    PremiumPlan(String n, String i) {
        super(n, i);
    }

    double calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends Subscription {

    FamilyPlan(String n, String i) {
        super(n, i);
    }

    double calculateMonthlyCharge() {
        return 799;
    }
}

public class Main {

    static void search(Subscription arr[], String id) {
        for (Subscription s : arr)
            if (s.subscriptionId.equals(id))
                System.out.println(s.subscriberName);
    }

    static void displayPrefix(Subscription arr[], char ch) {
        for (Subscription s : arr)
            if (s.subscriberName.startsWith("" + ch))
                System.out.println(s.subscriberName);
    }

    static double revenue(Subscription arr[]) {
        double sum = 0;
        for (Subscription s : arr)
            sum += s.calculateMonthlyCharge();
        return sum;
    }

    public static void main(String args[]) {

        Subscription arr[] = {
                new BasicPlan("Aman", "S1"),
                new PremiumPlan("Rahul", "S2"),
                new FamilyPlan("Anjali", "S3")
        };

        search(arr, "S2");

        displayPrefix(arr, 'A');

        System.out.println(revenue(arr));

        Subscription max = arr[0];

        for (Subscription s : arr)
            if (s.calculateMonthlyCharge() > max.calculateMonthlyCharge())
                max = s;

        System.out.println(max.subscriberName);
    }
}