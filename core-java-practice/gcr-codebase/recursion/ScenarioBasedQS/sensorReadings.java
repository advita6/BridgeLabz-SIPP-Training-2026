public class SensorReadings {

    public static boolean isStrictlyIncreasing(int[] readings) {
        return checkIncreasing(readings, 0);
    }

    private static boolean checkIncreasing(int[] readings, int index) {
        if (index >= readings.length - 1) {
            return true;
        }
        if (readings[index] >= readings[index + 1]) {
            return false;
        }
        return checkIncreasing(readings, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(isStrictlyIncreasing(new int[]{12, 15, 18, 22, 30}));
        System.out.println(isStrictlyIncreasing(new int[]{12, 15, 14, 22}));
    }
}