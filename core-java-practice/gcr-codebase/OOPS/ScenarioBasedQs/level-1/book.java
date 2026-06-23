public class Book {
    private String title;
    private String author;
    private double price;

    // Default Constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    // Parameterized Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Display method to verify details
    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
}