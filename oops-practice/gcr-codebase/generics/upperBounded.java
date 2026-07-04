import java.util.List;

public class UpperBoundedExample {
    // Read-only: We can safely read elements as 'Number'
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        // list.add(45.6); // Compile-time error! Read-only operation.
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.5, 2.5);

        System.out.println("Sum: " + sumOfList(integers));
        System.out.println("Sum: " + sumOfList(doubles));
    }
}