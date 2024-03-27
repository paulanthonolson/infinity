package bankaccountv1;

public class CheckingAccount {
	private String owner;
	private int accountNumber;
	private double balance;

	public CheckingAccount(int accountNumber, String owner, double initialDeposit) {
		// Since accountNumber is both an instance variable (declared in the class)
		// and an argument variable (declared in the method), we have to use
		// this.accountNumber to get to the instance variable and just accountNumber by
		// itself to get to the argument variable.
		this.accountNumber = accountNumber;

		// Duplicate variable name, so "this." needed
		this.owner = owner;

		// We could use this.balance, but since the instance variable balance
		// is different from argument variable initialDeposit, we can omit
		// "this." in front of balance.
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
