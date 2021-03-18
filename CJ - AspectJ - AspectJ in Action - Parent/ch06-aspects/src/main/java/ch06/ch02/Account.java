package ch06.ch02;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Account
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private int accountNumber;

	private float balance;

	public Account(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public void credit(float amount)
	{
		setBalance(getBalance() + amount);
	}

	public void debit(float amount) throws InsufficientBalanceException
	{
		if (amount > this.balance)
		{
			throw new InsufficientBalanceException(
					String.format(
							"total balance of account %d not sufficient",
							this.accountNumber));
		}
		setBalance(getBalance() - amount);
	}

	public float getBalance()
	{
		return this.balance;
	}

	public void setBalance(float balance)
	{
		this.balance = balance;
	}

	@Override
	public String toString()
	{
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("accountNumber", this.accountNumber);
		String result = builder.build();
		return result;
	}
}
