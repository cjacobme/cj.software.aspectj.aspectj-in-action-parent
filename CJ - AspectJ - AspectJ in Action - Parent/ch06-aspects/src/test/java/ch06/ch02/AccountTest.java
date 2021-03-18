package ch06.ch02;

import org.junit.Test;

public class AccountTest
{
	@Test
	public void twoAccounts() throws InsufficientBalanceException
	{
		SavingsAccount account1 = new SavingsAccount(12345);
		SavingsAccount account2 = new SavingsAccount(67890);
		account1.credit(100);
		account1.debit(50);
		account2.credit(100);
		account2.debit(50);
	}
}
