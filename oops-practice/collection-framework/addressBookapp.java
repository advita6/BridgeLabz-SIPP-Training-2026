import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
    }
}

public class AddressBookApp {
    private List<Contact> contactList = new ArrayList<>();
    private Map<String, Contact> nameMap = new HashMap<>();
    private Set<String> phoneSet = new HashSet<>();

    // 1. Add Contact
    public boolean addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Error: A contact with phone number " + phone + " already exists.");
            return false;
        }
        
        Contact newContact = new Contact(name, phone, email);
        contactList.add(newContact);
        nameMap.put(name.toLowerCase(), newContact); // Lowercase for case-insensitive lookup
        phoneSet.add(phone);
        System.out.println("Contact added successfully: " + name);
        return true;
    }

    // 2. Search Contact by Name
    public void searchContact(String name) {
        Contact contact = nameMap.get(name.toLowerCase());
        if (contact != null) {
            System.out.println("Contact Found -> " + contact);
        } else {
            System.out.println("Contact not found for name: " + name);
        }
    }

    // 3. Delete Contact by Name
    public boolean deleteContact(String name) {
        Contact contact = nameMap.get(name.toLowerCase());
        if (contact != null) {
            contactList.remove(contact);
            nameMap.remove(name.toLowerCase());
            phoneSet.remove(contact.phone);
            System.out.println("Contact deleted successfully: " + name);
            return true;
        }
        System.out.println("Delete failed. Contact not found: " + name);
        return false;
    }

    // 4. Display Sorted by Name
    public void displaySorted() {
        if (contactList.isEmpty()) {
            System.out.println("Address book is empty.");
            return;
        }
        // Sort using Collections.sort with a custom comparator
        Collections.sort(contactList, (c1, c2) -> c1.name.compareToIgnoreCase(c2.name));
        
        System.out.println("\n--- Address Book (Sorted by Name) ---");
        for (Contact c : contactList) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        AddressBookApp book = new AddressBookApp();
        
        book.addContact("Alice", "1234567890", "alice@email.com");
        book.addContact("Charlie", "9876543210", "charlie@email.com");
        book.addContact("Bob", "5556667777", "bob@email.com");
        
        // Attempting a duplicate phone number entry
        book.addContact("Fake Bob", "1234567890", "fake@email.com"); 

        book.displaySorted();
        book.searchContact("Bob");
        book.deleteContact("Charlie");
        book.displaySorted();
    }
}