package cj.software.aspectj.own.tracing.entity;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String name;

	private String surname;

	public Person(UUID id, String name, String surname)
	{
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public UUID getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getSurname()
	{
		return this.surname;
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
		if (otherObject instanceof Person)
		{
			Person other = (Person) otherObject;
			EqualsBuilder builder = new EqualsBuilder().append(this.id, other.id);
			result = builder.build();
		}
		else
		{
			result = false;
		}
		return result;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("Person[id=").append(this.id)
				.append(",name=")
				.append(this.name)
				.append(",surname=")
				.append(this.surname)
				.append("]");
		String result = sb.toString();
		return result;
	}
}
