package ch05.ch01.warehouse;

public class Inventory
{
	private String itemDescription;

	private int amount;

	public Inventory(String itemDescription)
	{
		this.itemDescription = itemDescription;
	}

	public int getAmount()
	{
		return this.amount;
	}

	public String getItemDescription()
	{
		return this.itemDescription;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public int withdraw(int number)
	{
		int newAmount = this.amount - number;
		this.setAmount(newAmount);
		return newAmount;
	}
}
