package bankaccountv3;

// In this program, uncomment individual lines, run the program, and observe what happens.

public class BankAccountDriver {

	public static void main(String[] args) {
		CheckingAccount checking = new CheckingAccount(1000, "My Checking", 100.00);
		// CheckingAccount badChecking1 = new CheckingAccount(-1, "Bad 1", 100);
		// CheckingAccount badChecking2 = new CheckingAccount(1002, "", 100);
		// CheckingAccount badChecking3 = new CheckingAccount(1003, "Bad 3", -100);

		System.out.println(checking);
		System.out.println("-----");

		checking.deposit(10);
		System.out.println(checking);
		System.out.println("-----");

		// checking.deposit(-10);
		System.out.println(checking);
		System.out.println("-----");

		checking.withdraw(25);
		System.out.println(checking);
		System.out.println("-----");

		checking.writeCheck("Pat Smith", 30);
		System.out.println(checking);
		System.out.println("-----");

		// checking.writeCheck("Robin Doe", 135);
		System.out.println(checking);
	}
}
