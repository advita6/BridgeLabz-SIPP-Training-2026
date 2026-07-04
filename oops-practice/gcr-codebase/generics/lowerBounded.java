import java.util.ArrayList;
import java.util.List;

public class LowerBoundedExample {
    // Write operation: Safe to add Integers because the list holds Integer or its superclasses
    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        
        // Object obj = list.get(0); // Reading returns 'Object', not 'Integer'
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList); 
        System.out.println(numberList); // Output: [10, 20]
    }
}