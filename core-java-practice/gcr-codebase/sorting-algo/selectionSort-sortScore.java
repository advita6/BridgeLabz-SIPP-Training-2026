public class SelectionSortScores {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] examScores = {74, 91, 53, 85, 68, 99};

        System.out.println("Original Exam Scores:");
        printArray(examScores);

        selectionSort(examScores);

        System.out.println("\nSorted Exam Scores (Ascending):");
        printArray(examScores);
    }

    private static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}