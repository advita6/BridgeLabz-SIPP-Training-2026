import java.util.Scanner;

public class MergeSortSalaries {

    public static void mergeSort(int[] salaries, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(salaries, left, mid);
            mergeSort(salaries, mid + 1, right);

            // Merge the sorted halves
            merge(salaries, left, mid, right);
        }
    }

    private static void merge(int[] salaries, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = salaries[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = salaries[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        // Merge the temp arrays back into the original array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                salaries[k] = L[i];
                i++;
            } else {
                salaries[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            salaries[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            salaries[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] salaries = new int[n];
            
            // Read input, handling potential brackets like "[45000" in standard input
            for (int i = 0; i < n; i++) {
                String token = sc.next().replaceAll("\\[|\\]", "");
                salaries[i] = Integer.parseInt(token);
            }

            mergeSort(salaries, 0, n - 1);

            // Print Output
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(salaries[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println("]");
        }
        sc.close();
    }
}