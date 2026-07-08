public class AstronomerCatalog {

    // 1. Standard Binary Search O(log n)
    public static int standardSearch(double[] catalog, double target) {
        int left = 0, right = catalog.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (catalog[mid] == target) return mid;
            if (catalog[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 2. Search in a Rotated Sorted Catalog
    public static int searchRotated(double[] catalog, double target) {
        int left = 0, right = catalog.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (catalog[mid] == target) return mid;

            // Check if left half is sorted
            if (catalog[left] <= catalog[mid]) {
                if (target >= catalog[left] && target < catalog[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Right half must be sorted
            else {
                if (target > catalog[mid] && target <= catalog[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // 3. Find First Occurrence of a Repeated Value
    public static int findFirstOccurrence(double[] catalog, double target) {
        int left = 0, right = catalog.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (catalog[mid] == target) {
                result = mid;
                right = mid - 1; // Keep searching left
            } else if (catalog[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 4. Find Last Occurrence of a Repeated Value
    public static int findLastOccurrence(double[] catalog, double target) {
        int left = 0, right = catalog.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (catalog[mid] == target) {
                result = mid;
                left = mid + 1; // Keep searching right
            } else if (catalog[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 5. Find the Minimum Element in a Rotated Catalog
    public static double findMinimum(double[] catalog) {
        int left = 0, right = catalog.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (catalog[mid] > catalog[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return catalog[left];
    }
}