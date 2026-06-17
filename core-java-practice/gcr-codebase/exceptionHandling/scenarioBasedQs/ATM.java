class InsufficientBalanceException extends Exception {
    private final double currentBalance;
    private final double requestedAmount;

    public InsufficientBalanceException(double currentBalance, double requestedAmount) {
        super("Withdrawal failed: Requested amount (₹" + requestedAmount + ") exceeds current balance (₹" + currentBalance + ").");
        this.currentBalance = currentBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}