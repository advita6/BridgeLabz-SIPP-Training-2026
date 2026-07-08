public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Flags to check bounds safely
            boolean greaterThanLeft = (mid == 0 || arr[mid] >= arr[mid - 1]);
            boolean greaterThanRight = (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);

            // If mid is greater than or equal to its neighbors, it's a peak
            if (greaterThanLeft && greaterThanRight) {
                return arr[mid]; 
                // Note: return 'mid' here instead if you need the index
            } 
            // If the element to the left is greater, search the left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            } 
            // If the element to the right is greater, search the right half
            else {
                left = mid + 1;
            }
        }
        
        return -1; // Fallback in case of empty array
    }

    public static void main(String[] args) {
        int[] terrain = {1, 3, 20, 4, 1, 0};
        int peakValue = findPeakElement(terrain);
        
        System.out.println("A peak element found is: " + peakValue);
    }
}