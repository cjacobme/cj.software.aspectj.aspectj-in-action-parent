package cj.software.aspectj.own.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Person
		implements
		Serializable
{
	static final long serialVersionUID = 1L;

	private String name;

	private LocalDate birthday;

	private Address address;

	private Person()
	{
	}

	public String getName()
	{
		return this.name;
	}

	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	public Address getAddress()
	{
		return this.address;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	public static class Builder
	{
		private Person instance;

		protected Builder()
		{
			this.instance = new Person();
		}

		public Builder withName(String name)
		{
			this.instance.name = name;
			return this;
		}

		public Builder withBirthday(LocalDate birthday)
		{
			this.instance.birthday = birthday;
			return this;
		}

		public Builder withAddress(Address address)
		{
			this.instance.address = address;
			return this;
		}

		public Person build()
		{
			Person result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
