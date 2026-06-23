import java.util.ArrayList;
import java.util.List;

class BankAccount {
    // Static field to track total accounts created
    private static int totalAccountsCreated = 0;

    // Instance variables
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.transactionHistory.add("Account opened with initial balance: $" + initialBalance);
        totalAccountsCreated++; // Increment static counter
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transactionHistory.add("Deposited: $" + amount + " | Balance: $" + this.balance);
            System.out.println(holderName + " deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method with Overdraft Check
    public void withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                this.transactionHistory.add("Withdrew: $" + amount + " | Balance: $" + this.balance);
                System.out.println(holderName + " withdrew $" + amount);
            } else {
                this.transactionHistory.add("Failed Withdrawal Attempt: $" + amount + " (Insufficient Funds)");
                System.out.println("Transaction Denied for " + holderName + ": Overdraft blocked. Insufficient funds.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Get Statement method
    public void getStatement() {
        System.out.println("\n=== Account Statement for " + this.holderName + " (" + this.accountNumber + ") ===");
        for (String txn : this.transactionHistory) {
            System.out.println("- " + txn);
        }
        System.out.println("Final Balance: $" + this.balance);
        System.out.println("================================================");
    }

    // Static getter for total accounts
    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }
}

public class MainBankSystem {
    public static void main(String[] args) {
        // Creating 3 accounts
        BankAccount acc1 = new BankAccount("ACC001", "Alice", 1000.0);
        BankAccount acc2 = new BankAccount("ACC002", "Bob", 500.0);
        BankAccount acc3 = new BankAccount("ACC003", "Charlie", 2500.0);

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccountsCreated() + "\n");

        // Simulating 5 transactions for Alice
        acc1.deposit(200);
        acc1.withdraw(150);
        acc1.deposit(50);
        acc1.withdraw(1200); // Should trigger overdraft check failure
        acc1.withdraw(50);

        // Simulating 5 transactions for Bob
        acc2.withdraw(100);
        acc2.deposit(300);
        acc2.withdraw(50);
        acc2.withdraw(700); // Overdraft failure
        acc2.deposit(100);

        // Simulating 5 transactions for Charlie
        acc3.deposit(500);
        acc3.withdraw(1000);
        acc3.deposit(200);
        acc3.withdraw(100);
        acc3.deposit(50);

        // Printing Statements
        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();
    }
}