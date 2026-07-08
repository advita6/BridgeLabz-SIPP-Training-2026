public class InsertionSortEmployees {

    public static void insertionSort(int[] empIds) {
        int n = empIds.length;
        
        // Start from the second element (index 1) as index 0 is trivially sorted
        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;

            /* Move elements of empIds[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j = j - 1;
            }
            // Insert the key into its correct position
            empIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIds = {1015, 1002, 1089, 1043, 1007, 1022};

        System.out.println("Original Employee IDs:");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.println("\nSorted Employee IDs (Ascending):");
        printArray(employeeIds);
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}