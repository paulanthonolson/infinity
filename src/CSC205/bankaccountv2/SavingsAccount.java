package bankaccountv2;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(int accountNumber, String owner, double initialDeposit, double interestRate) {

        super(accountNumber, owner, initialDeposit);

        if (interestRate < 0 || interestRate > 0.1) {

            System.err.printf("Interest rate %.3f must be between 0 and 0.1\n", interestRate);
        } else {

            this.interestRate = interestRate;
        }

    }

    public double getInterestRate() {
        return interestRate;
    }

    public void earnInterest() {

        deposit(getBalance() * interestRate / 12);
    }

    public String toString() {
        String result;
        result = super.toString() + String.format(" Interest: %.1f%%", interestRate * 100);
        return result;
    }
}
