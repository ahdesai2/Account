package accountunittest;

public class AccountTest {
    public static void main(String[] args) {
        // Creating accounts
        Account account1 = new Account("Ted Murphy", 72354, 102.56);
        Account account2 = new Account("Jane Smith", 69713, 40.00);
        Account account3 = new Account("Edward Demsey", 93757, 759.32);
        Account account4 = account1; // Alias of Account1

        // Running tests
        testAlias(account1, account4);
        testDeposit(account1);
        testWithdraw(account2);
        testAddInterest(account3);
        testToString(account2);
    }

    // b. Test method to check if Account1 and Account4 are aliases
    public static void testAlias(Account account1, Account account4) {
        if (account1 == account4) {
            System.out.println("testAlias passed");
        } else {
            System.out.println("testAlias failed");
        }
    }

    // c. Test method for deposit
    public static void testDeposit(Account account1) {
        try {
            double initialBalance = account1.getBalance();
            double depositAmount = 100.00;
            double expectedBalance = initialBalance + depositAmount;
            account1.deposit(depositAmount);
            if (account1.getBalance() == expectedBalance) {
                System.out.println("testDeposit passed");
            } else {
                System.out.println("testDeposit failed: expected " + expectedBalance + " but got " + account1.getBalance());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("testDeposit failed with exception: " + e.getMessage());
        }

        // Testing exception in deposit method
        try {
            account1.deposit(-50.00);
            System.out.println("testDeposit failed: No exception thrown for negative deposit");
        } catch (IllegalArgumentException e) {
            System.out.println("testDeposit passed for negative deposit: " + e.getMessage());
        }
    }

    // d. Test method for withdraw
    public static void testWithdraw(Account account2) {
        if (account2 != null) {
            double initialBalance = account2.getBalance();
            double withdrawAmount = 10.00;
            double fee = 2.00;
            double expectedBalance = initialBalance - withdrawAmount - fee;
            account2.withdraw(withdrawAmount, fee);
            if (account2.getBalance() == expectedBalance) {
                System.out.println("testWithdraw passed");
            } else {
                System.out.println("testWithdraw failed: expected " + expectedBalance + " but got " + account2.getBalance());
            }
        } else {
            System.out.println("testWithdraw failed: Account2 is null");
        }
    }

    // e. Test method for addInterest
    public static void testAddInterest(Account account3) {
        double initialBalance = account3.getBalance();
        double interestRate = 0.035;
        double expectedBalance = initialBalance + (initialBalance * interestRate);
        account3.addInterest();
        if (account3.getBalance() == expectedBalance) {
            System.out.println("testAddInterest passed");
        } else {
            System.out.println("testAddInterest failed: expected " + expectedBalance + " but got " + account3.getBalance());
        }
    }

    // f. Test method for toString
    public static void testToString(Account account2) {
        String expectedString = "69713\tJane Smith\t$40.00";
        if (account2.toString().equals(expectedString)) {
            System.out.println("testToString passed");
        } else {
            System.out.println("testToString failed: expected \"" + expectedString + "\" but got \"" + account2.toString() + "\"");
        }
    }
}
