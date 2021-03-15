package ch05.ch01;

public class Account
		implements
		BeanSupport
{
	private String id;

	private double balance;

	private void setBalance(double balance)
	{
		this.balance = balance;
	}

	public Account(String id, double startingBalance)
	{
		this.id = id;
		this.balance = startingBalance;
	}

	public double debit(double amount)
	{
		double result = this.balance - amount;
		this.setBalance(result);
		return result;
	}

	public String getId()
	{
		return this.id;
	}

	public double getBalance()
	{
		return this.balance;
	}
}
