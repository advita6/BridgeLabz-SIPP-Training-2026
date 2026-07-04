// Restricts T to only classes that extend the Number class
public class Box<T extends Number> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    public void displayIntValue() {
        // Safe to call intValue() because T is guaranteed to be a Number
        System.out.println("Integer value: " + data.intValue());
    }

    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(123); // Valid
        Box<Double> doubleBox = new Box<>(55.5); // Valid
        
        // Box<String> stringBox = new Box<>("Hello"); // Compile error! String is not a Number.
        intBox.displayIntValue();
    }
}