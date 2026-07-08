public class BubbleSortStudents {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        
        // Loop through all array elements
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Last i elements are already in place, so skip them
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    
                    swapped = true;
                }
            }
            
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {85, 62, 94, 45, 78, 88};
        
        System.out.println("Original Student Marks:");
        printArray(studentMarks);

        bubbleSort(studentMarks);

        System.out.println("\nSorted Student Marks (Ascending):");
        printArray(studentMarks);
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}