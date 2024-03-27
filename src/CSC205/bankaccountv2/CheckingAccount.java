package bankaccountv2;

public class CheckingAccount extends BankAccount {

	public CheckingAccount(int accountNumber, String owner, double initialDeposit) {

		super(accountNumber, owner, initialDeposit);

	}

	public void writeCheck(String payee, double amount) {
		withdraw(amount);
		System.out.printf("Pay to %s $%.2f\n", payee, amount);
	}

}
