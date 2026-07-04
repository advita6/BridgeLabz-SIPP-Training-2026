public class GenericMethodExample {
    // Single method capable of printing arrays of any object type
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);    // Reuses the same method
        printArray(stringArray); // Reuses the same method
    }
}