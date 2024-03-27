package bankaccountv3;

public class CheckingAccount {
    private int accountNumber;
    private String owner;
    private double balance;

    public CheckingAccount(int accountNumber, String owner, double initialDeposit) {
        if (accountNumber <= 0) {
            throw new IllegalArgumentException("Account number " + accountNumber + " may not be negative");
        }
        if (owner == null || owner.equals("")) {
            throw new IllegalArgumentException("Owner may not be null or empty");
        }
        if (initialDeposit < 0) {
            throw new IllegalArgumentException(
                    String.format("Initial deposit $%.2f may not be negative", initialDeposit));
        }

        this.accountNumber = accountNumber;
        this.owner = owner;
        balance = initialDeposit;
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
            throw new IllegalArgumentException(String.format("Deposit $%.2f may not be negative", amount));
        }

        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(String.format("Withdrawal $%.2f may not be negative", amount));
        }
        if (amount > balance) {
            throw new IllegalArgumentException(
                    String.format("Withdrawal $%.2f may not exceed balance $%.2f", amount, balance));
        }

        balance = balance - amount;
    }

    public void writeCheck(String payee, double amount) {
        withdraw(amount);
        System.out.printf("Pay to %s $%.2f\n", payee, amount);
    }

    public String toString() {
        String result;
        result = String.format("Account: %d  Owner: %s  Balance: $%.2f", accountNumber, owner, balance);
        return result;
    }
}
