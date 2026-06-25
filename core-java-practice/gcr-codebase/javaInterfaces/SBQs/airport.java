interface LuggageScanner {
    boolean scanLuggage(double weightKg, boolean hasProhibitedItems);

    default void displaySecurityGuidelines() {
        System.out.println("[Luggage Safety]: No liquids over 100ml. No sharp objects in hand carry.");
    }
}

interface PassportVerifier {
    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("[Identity Verification]: Present a valid passport and physical boarding pass.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("^[A-Z0-9]{6,9}$");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    
    @Override
    public boolean scanLuggage(double weightKg, boolean hasProhibitedItems) {
        return weightKg <= 23.0 && !hasProhibitedItems;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {
        System.out.println("=== MANDATORY AIRPORT SECURITY GUIDELINES ===");
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
        System.out.println("=============================================");
    }

    public void processPassengers(String[] names, String[] passportNumbers, double[] luggageWeights, boolean[] forbiddenItems) {
        displaySecurityGuidelines();
        System.out.println("\n=== Processing Passenger Boarding Status ===");

        for (int i = 0; i < names.length; i++) {
            System.out.println("\nChecking Passenger: " + names[i]);
            
            boolean passportClear = verifyPassport(passportNumbers[i]);
            boolean luggageClear = scanLuggage(luggageWeights[i], forbiddenItems[i]);

            if (!passportClear) {
                System.out.println("-> Status: REJECTED (Invalid Passport Format: " + passportNumbers[i] + ")");
            } else if (!luggageClear) {
                System.out.println("-> Status: REJECTED (Luggage violation: " + luggageWeights[i] + "kg, Prohibited items: " + forbiddenItems[i] + ")");
            } else {
                System.out.println("-> Status: APPROVED FOR BOARDING");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] passengerNames = {"Alice Smith", "Bob Jones", "Charlie Brown"};
        String[] passports = {"A1234567", "INVALID_PASS", "B9876543"};
        double[] weights = {18.5, 12.0, 32.5};
        boolean[] restrictedItems = {false, false, true};

        AirportSecuritySystem security = new AirportSecuritySystem();
        security.processPassengers(passengerNames, passports, weights, restrictedItems);
    }
}