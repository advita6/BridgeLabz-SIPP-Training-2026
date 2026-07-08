import java.util.HashSet;

public class EventVerificationSystem {
    private HashSet<String> registeredEmails = new HashSet<>();

    // 1 & 2. Register Participant & Prevent Duplicates
    public void registerParticipant(String emailId) {
        String cleanEmail = emailId.trim().toLowerCase();
        
        // HashSet.add() returns false if the item already exists in the set
        if (registeredEmails.add(cleanEmail)) {
            System.out.println("Registration successful for: " + emailId);
        } else {
            System.out.println("Rejected: Duplicate entry. Email '" + emailId + "' is already registered.");
        }
    }

    // 3 & 4. Display Unique Participants and Total Attendees
    public void displayEventSummary() {
        System.out.println("\n--- Event Registration Summary ---");
        System.out.println("Total Eligible Attendees: " + registeredEmails.size());
        if (registeredEmails.isEmpty()) {
            System.out.println("No participants registered yet.");
        } else {
            System.out.println("List of Registered Participants:");
            for (String email : registeredEmails) {
                System.out.println("- " + email);
            }
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        EventVerificationSystem eventSystem = new EventVerificationSystem();

        eventSystem.registerParticipant("john.doe@example.com");
        eventSystem.registerParticipant("alice.smith@example.com");
        
        // Duplicate attempts
        eventSystem.registerParticipant("john.doe@example.com"); 
        eventSystem.registerParticipant("JOHN.DOE@example.com"); // Case variations handled

        eventSystem.registerParticipant("bob.jones@example.com");

        eventSystem.displayEventSummary();
    }
}