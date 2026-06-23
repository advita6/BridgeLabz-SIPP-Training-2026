public class Product {
    // 1. Static variable shared across all products (e.g., 10.0 for 10%)
    private static double discount = 0.0;

    // 3. Final variable ensuring a unique, unchangeable ID per product
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    // Constructor
    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID; // Final variable assigned once here
        
        // 2. Use 'this' to resolve naming conflicts between parameters and instance variables
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // 1. Static method to modify the discount percentage for all products
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to calculate total price after applying the shared discount
    public double calculateDiscountedTotal() {
        double totalBeforeDiscount = this.price * this.quantity;
        return totalBeforeDiscount * (1 - (discount / 100));
    }

    // Method to display item details
    public void displayProductDetails() {
        System.out.println("Product ID: " + this.productID);
        System.out.println("Item Name: " + this.productName);
        System.out.println("Unit Price: $" + this.price + " | Quantity: " + this.quantity);
        System.out.println("Current Global Discount: " + discount + "%");
        System.out.println("Total Cost: $" + String.format("%.2f", calculateDiscountedTotal()));
        System.out.println("-----------------------------------");
    }
}