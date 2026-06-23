public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default Constructor (Chained to Parameterized)
    public HotelBooking() {
        this("Guest", "Standard", 1);
    }

    // Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy Constructor
    public HotelBooking(HotelBooking otherBooking) {
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    public void displayBooking() {
        System.out.println("Guest: " + guestName + " | Room: " + roomType + " | Nights: " + nights);
    }
}