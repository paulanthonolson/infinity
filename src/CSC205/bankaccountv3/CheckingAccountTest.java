package bankaccountv3;

// See https://csem.cc/link/csc205ab/module-g - Enable JUnit Testing in VS Code
// for information on how to enable and run tests

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest {
    // These values will be used to set up testAccount before each test.
    private static final int ACCOUNT_NUMBER = 1000;
    private static final String OWNER = "Owner, Test";
    private static final double INITIAL_BALANCE = 100.00;

    // When two doubles are compared in Java, they may be slightly off from each
    // other. We use a delta value to test if they are close enough to each other to
    // be considered equal.
    private static final double DELTA = 0.00000001;

    private CheckingAccount testAccount;

    @BeforeEach
    public void init() {
        testAccount = new CheckingAccount(ACCOUNT_NUMBER, OWNER, INITIAL_BALANCE);
    }

    @Test
    public void givenTestAccount_whenGetAccountNumberCalled_thenAccountNumberReturned() {
        assertEquals(ACCOUNT_NUMBER, testAccount.getAccountNumber());
    }

    @Test
    public void givenTestAccount_whenGetOwnerCalled_thenOwnerReturned() {
        assertEquals(OWNER, testAccount.getOwner());
    }

    @Test
    public void givenTestAccount_whenDepositPositive_thenDepositSucceeds() {
        double testAmount = 200;

        testAccount.deposit(testAmount);
        assertEquals(INITIAL_BALANCE + testAmount, testAccount.getBalance(), DELTA);
    }

    @Test
    public void givenTestAccount_whenDepositNegative_thenThrowsException() {
        double depositAmount = -200;

        assertThrows(IllegalArgumentException.class, () -> {
            testAccount.deposit(depositAmount);
        });
    }

    @Test
    public void givenTestAccount_whenWithdrawPositiveAndWithinBalance_thenWithdrawSucceeds() {
        double withdrawAmount = INITIAL_BALANCE / 2;

        testAccount.withdraw(withdrawAmount);
        assertEquals(INITIAL_BALANCE - withdrawAmount, testAccount.getBalance(), DELTA);
    }

    @Test
    public void givenTestAccount_whenWithdrawNegative_thenThrowsException() {
        double withdrawAmount = -10;

        assertThrows(IllegalArgumentException.class, () -> {
            testAccount.withdraw(withdrawAmount);
        });
    }

    @Test
    public void givenTestAccount_whenWithdrawExceedsBalance_thenThrowsException() {
        double withdrawAmount = INITIAL_BALANCE * 2;

        assertThrows(IllegalArgumentException.class, () -> {
            testAccount.withdraw(withdrawAmount);
        });
    }

    @Test
    public void givenTestAccount_whenWriteCheckWithinBalance_thenWriteCheckSucceeds() {
        double checkAmount = INITIAL_BALANCE;

        testAccount.writeCheck("Some One", checkAmount);
        assertEquals(INITIAL_BALANCE - checkAmount, testAccount.getBalance(), DELTA);
    }

    @Test
    public void givenTestAccount_whenWriteCheckExceedsBalance_thenThrowsException() {
        double checkAmount = INITIAL_BALANCE * 2;

        assertThrows(IllegalArgumentException.class, () -> {
            testAccount.writeCheck("Some One", checkAmount);
        });
    }

}
