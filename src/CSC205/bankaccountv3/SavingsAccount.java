package bankaccountv3;

public class SavingsAccount {
    private int accountNumber;
    private String owner;
    private double balance;
    // Interest rate stored as a decimal (e.g., 1% stored as 0.01)
    private double interestRate;

    public SavingsAccount(int accountNumber, String owner, double initialDeposit, double interestRate) {
        // Since accountNumber is both an instance variable (declared in the class)
        // and an argument variable (declared in the method), we have to use
        // this.accountNumber to get to the instance variable and just accountNumber by
        // itself to get to the argument variable.
        this.accountNumber = accountNumber;

        // Duplicate variable name, so "this." needed
        this.owner = owner;

        // We could use this.balance, but since the instance variable balance
        // is different from argument variable initialDeposit, we can omit
        // this. in front of balance.
        balance = initialDeposit;

        if (interestRate < 0 || interestRate > 0.1) {
            // No "this." here as we want the argument variable
            System.err.printf("Interest rate %.3f must be between 0 and 0.1\n", interestRate);
        } else {
            // Duplicate variable name, so "this." needed
            this.interestRate = interestRate;
        }
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

    public double getInterestRate() {
        return interestRate;
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

    public void earnInterest() {
        // When interest is compounded monthly, you get 1/12th the interest every month.
        deposit(getBalance() * interestRate / 12);
    }

    public String toString() {
        String result;
        result = String.format("Account: %d  Owner: %s  Balance: $%.2f  Interest: %.1f%%",
                accountNumber, owner, balance, interestRate * 100);
        return result;
    }
}
