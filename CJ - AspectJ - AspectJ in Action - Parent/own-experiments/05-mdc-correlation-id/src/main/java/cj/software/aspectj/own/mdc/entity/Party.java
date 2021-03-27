package cj.software.aspectj.own.mdc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Party
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String name;

	private LocalDate founded;

	public UUID getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public LocalDate getFounded()
	{
		return this.founded;
	}

	public Party(UUID id, String name, LocalDate founded)
	{
		super();
		this.id = id;
		this.name = name;
		this.founded = founded;
	}

	@Override
	public String toString()
	{
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("id", this.id)
				.append("name", this.name);
		String result = builder.build();
		return result;
	}

	@Override
	public boolean equals(Object otherObject)
	{
		boolean result;
		if (otherObject instanceof Party)
		{
			Party other = (Party) otherObject;
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
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder().append(this.id);
		int result = builder.build();
		return result;
	}
}
