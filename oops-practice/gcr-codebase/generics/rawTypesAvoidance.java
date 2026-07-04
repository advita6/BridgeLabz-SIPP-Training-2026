import java.util.ArrayList;
import java.util.List;

public class RawTypesAvoidance {
    public static void main(String[] args) {
        // BAD: Raw type allows any Object, risking Runtime crashes
        List rawList = new ArrayList(); 
        rawList.add("Hello");
        rawList.add(100); // Compiles fine, but dangerous

        // GOOD: Parameterized type ensures safety
        List<String> cleanList = new ArrayList<>();
        cleanList.add("Hello");
        // cleanList.add(100); // Caught by the compiler immediately
    }
}