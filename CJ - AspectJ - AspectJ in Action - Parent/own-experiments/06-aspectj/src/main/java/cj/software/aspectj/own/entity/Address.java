package cj.software.aspectj.own.entity;

import java.io.Serializable;

public class Address
		implements
		Serializable
{
	static final long serialVersionUID = 1L;

	private String street;

	private String zip;

	private String city;

	private Address()
	{
	}

	public String getStreet()
	{
		return this.street;
	}

	public String getZip()
	{
		return this.zip;
	}

	public String getCity()
	{
		return this.city;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	public static class Builder
	{
		protected Address instance;

		protected Builder()
		{
			this.instance = new Address();
		}

		public Builder withStreet(String street)
		{
			this.instance.street = street;
			return this;
		}

		public Builder withZip(String zip)
		{
			this.instance.zip = zip;
			return this;
		}

		public Builder withCity(String city)
		{
			this.instance.city = city;
			return this;
		}

		public Address build()
		{
			Address result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
