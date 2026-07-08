import java.util.Scanner;

public class MergeSortPatients {

    public static void mergeSort(int[] patientIDs, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(patientIDs, left, mid);
            mergeSort(patientIDs, mid + 1, right);
            merge(patientIDs, left, mid, right);
        }
    }

    private static void merge(int[] patientIDs, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = patientIDs[left + i];
        for (int j = 0; j < n2; ++j) R[j] = patientIDs[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                patientIDs[k] = L[i];
                i++;
            } else {
                patientIDs[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            patientIDs[k] = L[i];
            i++; k++;
        }

        while (j < n2) {
            patientIDs[k] = R[j];
            j++; k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] patientIDs = new int[n];
            
            for (int i = 0; i < n; i++) {
                String token = sc.next().replaceAll("\\[|\\]", "");
                patientIDs[i] = Integer.parseInt(token);
            }

            mergeSort(patientIDs, 0, n - 1);

            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(patientIDs[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println("]");
        }
        sc.close();
    }
}