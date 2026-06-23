public class Circle {
    private double radius;

    // Default Constructor chaining to the parameterized constructor
    public Circle() {
        this(1.0); // Calls the parameterized constructor with a default value
    }

    // Parameterized Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}