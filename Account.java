package accountunittest;
import java.text.NumberFormat;
public class Account
{
 private final double RATE = 0.035; // interest rate of 3.5%
 private long acctNumber;
 private double balance;
 private String name;
 public Account (String owner, long account, double initial)
 {
 name = owner;
 acctNumber = account;
 balance = initial;
 }
 public double deposit (double amount)
 {
if(amount <= 0) throw new IllegalArgumentException("Not allowed Negative value for deposit");
 balance = balance + amount;
 return balance;
 }
 public double withdraw (double amount, double fee)
 {
 balance = balance - amount - fee;
 return balance;
 }
 public double addInterest ()
 {
 balance += (balance * RATE);
 return balance;
 }
 public double getBalance ()
 {
 return balance;
 }
 public String toString ()
 {
 NumberFormat fmt = NumberFormat.getCurrencyInstance();
 return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
 }
public static void main(String[] args) {
    // Creating accounts
    Account account1 = new Account("Ted Murphy", 72354, 102.56);
    Account account2 = new Account("Jane Smith", 69713, 40.00);
    Account account3 = new Account("Edward Demsey", 93757, 759.32);
    Account account4 = account1; // Alias of Account1

    // Running tests
    AccountTest.testAlias(account1, account4);
    AccountTest.testDeposit(account1);
    AccountTest.testWithdraw(account2);
    AccountTest.testAddInterest(account3);
    AccountTest.testToString(account2);
}
}

