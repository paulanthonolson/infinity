package bankaccountv2;

public class BankAccountDriver {

	public static void main(String[] args) {
		CheckingAccount checking = new CheckingAccount(1000, "My Checking", 100.00);
		SavingsAccount savings = new SavingsAccount(1001, "My Savings ", 200.00, 0.01);

		System.out.println(checking);
		System.out.println(savings);
		System.out.println("-----");

		savings.deposit(10);
		System.out.println(savings);
		System.out.println("-----");

		savings.deposit(-10);
		System.out.println(savings);
		System.out.println("-----");

		checking.withdraw(25);
		System.out.println(checking);
		System.out.println("-----");

		checking.writeCheck("Pat Smith", 30);
		System.out.println(checking);
		System.out.println("-----");

		checking.writeCheck("Robin Doe", 135);
		System.out.println(checking);
		System.out.println("-----");

		savings.earnInterest();
		System.out.println(savings);
	}
}
