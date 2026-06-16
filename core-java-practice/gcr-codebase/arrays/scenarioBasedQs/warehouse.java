import java.util.ArrayList;
import java.util.Scanner;

public class warehouseStockRecovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> stockList = new ArrayList<>();

        System.out.println("--- Warehouse Stock Recovery System ---");
        System.out.println("Enter stock quantities (type 'r' to recover and finish):");

        while (scanner.hasNextDouble()) {
            stockList.add(scanner.nextDouble());
        }

        if (stockList.isEmpty()) {
            System.out.println("No stock data entered. Exiting program.");
            scanner.close();
            return;
        }

        int zeroIndex = -1;
        double nonZeroSum = 0;
        int nonZeroCount = 0;

        for (int i = 0; i < stockList.size(); i++) {
            double currentStock = stockList.get(i);
            if (currentStock == 0) {
                zeroIndex = i;
            } else {
                nonZeroSum += currentStock;
                nonZeroCount++;
            }
        }

        if (zeroIndex == -1) {
            System.out.println("\nNo glitch detected. No product has a stock of 0.");
            scanner.close();
            return;
        }

        double averageStock = nonZeroCount > 0 ? (nonZeroSum / nonZeroCount) : 0;
        stockList.set(zeroIndex, averageStock);

        System.out.println("\n================ SYSTEM REPORT ================");
        System.out.println("Glitched Position Identified (Index): " + zeroIndex);
        System.out.println("Glitched Position Identified (Item #): " + (zeroIndex + 1));
        System.out.printf("Calculated Replacement Average:       %.2f\n", averageStock);
        System.out.println("-----------------------------------------------");
        System.out.print("Updated Inventory: [");
        for (int i = 0; i < stockList.size(); i++) {
            System.out.printf("%.1f", stockList.get(i));
            if (i < stockList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.util.println("]");
        System.out.println("===============================================");

        scanner.close();
    }
}