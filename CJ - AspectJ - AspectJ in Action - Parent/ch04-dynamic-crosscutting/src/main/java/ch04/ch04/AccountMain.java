package ch04.ch04;

import java.util.UUID;

public class AccountMain
{
	public static void main(String[] args)
	{
		Account account = new Account(UUID.randomUUID(), 25.27);
		account.credit(2.53);
	}
}
