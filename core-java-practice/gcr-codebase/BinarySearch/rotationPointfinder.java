public class RotationPointFinder {

    public static int findRotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Binary search for the smallest element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element, 
            // the smallest value must be to the right.
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            // Otherwise, the smallest value is at mid or to the left of mid.
            else {
                right = mid;
            }
        }
        
        // When left == right, we have found the smallest element's index
        return left; 
    }

    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12};
        int rotationIndex = findRotationIndex(rotatedArray);
        
        System.out.println("The rotation point is at index: " + rotationIndex);
        System.out.println("The smallest element is: " + arr[rotationIndex]);
    }
}