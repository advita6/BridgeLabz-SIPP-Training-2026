import java.util.ArrayList;
import java.util.List;

public class TypeSafetyExample {
    public static void main(String[] args) {
        // Enforces that ONLY Strings can be added
        List<String> names = new ArrayList<>();
        names.add("Alice");
        // names.add(123); // Compile-time error! Prevents bugs early.

        // No explicit casting required when retrieving
        String name = names.get(0); 
        System.out.println("Name: " + name);
    }
}