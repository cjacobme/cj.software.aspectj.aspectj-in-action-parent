package ch04.ch04;

import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Account
{
	private UUID id;

	private double balance;

	public Account(UUID id, double balance)
	{
		super();
		this.id = id;
		this.balance = balance;
	}

	@Override
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder().append(this.id);
		int result = builder.build();
		return result;
	}

	@Override
	public boolean equals(Object otherObject)
	{
		boolean result;
		if (otherObject instanceof Account)
		{
			Account other = (Account) otherObject;
			EqualsBuilder builder = new EqualsBuilder().append(this.id, other.id);
			result = builder.build();
		}
		else
		{
			result = false;
		}
		return result;
	}

	public UUID getId()
	{
		return this.id;
	}

	public double getBalance()
	{
		return this.balance;
	}

	@Override
	public String toString()
	{
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("id", this.id);
		String result = builder.build();
		return result;
	}

	public void credit(double amount)
	{
		this.balance -= amount;
	}
}
