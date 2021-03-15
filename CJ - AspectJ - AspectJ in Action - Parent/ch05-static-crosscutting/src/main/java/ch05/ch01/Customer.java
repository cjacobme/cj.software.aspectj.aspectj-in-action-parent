package ch05.ch01;

public class Customer
		implements
		BeanSupport
{
	private String address;

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

}
