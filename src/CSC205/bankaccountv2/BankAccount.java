package bankaccountv2;

public class BankAccount {
    private int accountNumber;
    private String owner;
    private double balance;

    public BankAccount(int accountNumber, String owner, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialDeposit;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.err.printf("Deposit $%.2f may not be negative\n", amount);
        } else {
            balance = balance + amount;
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            System.err.printf("Withdrawal $%.2f may not be negative\n", amount);
        } else if (amount > balance) {
            System.err.printf("Withdrawal $%.2f exceeds balance $%.2f\n", amount, balance);
        } else {
            balance = balance - amount;
        }
    }

    public String toString() {
        String result;
        result = String.format("Account: %d  Owner: %s  Balance: $%.2f", getAccountNumber(), getOwner(), getBalance());
        return result;
    }

}
