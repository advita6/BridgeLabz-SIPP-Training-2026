// Base Class
class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed (Date: " + orderDate + ")";
    }
}

// Subclass extending Order
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking No: " + trackingNumber + ")";
    }
}

// Subclass extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

// Demonstration Class
public class RetailManagement {
    public static void main(String[] args) {
        Order order1 = new Order("ORD001", "2026-06-28");
        Order order2 = new ShippedOrder("ORD002", "2026-06-29", "TRK987654");
        Order order3 = new DeliveredOrder("ORD003", "2026-06-25", "TRK123456", "2026-06-27");

        System.out.println("Order 1 Status: " + order1.getOrderStatus());
        System.out.println("Order 2 Status: " + order2.getOrderStatus());
        System.out.println("Order 3 Status: " + order3.getOrderStatus());
    }
}