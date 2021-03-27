package cj.software.aspectj.own.mdc.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Service
		implements
		Serializable,
		Comparable<Service>
{
	private static final long serialVersionUID = 1L;

	private OffsetDateTime started;

	private OffsetDateTime finished;

	private String description;

	private double toBePayed;

	public OffsetDateTime getStarted()
	{
		return this.started;
	}

	public OffsetDateTime getFinished()
	{
		return this.finished;
	}

	public String getDescription()
	{
		return this.description;
	}

	public double getToBePayed()
	{
		return this.toBePayed;
	}

	public void finish(OffsetDateTime finished, double toBePayed)
	{
		this.finished = finished;
		this.toBePayed = toBePayed;
	}

	public Service(OffsetDateTime started, String description)
	{
		super();
		this.started = started;
		this.description = description;
	}

	@Override
	public String toString()
	{
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append(
						"started",
						this.started != null
								? DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.started)
								: null).append("description", this.description);
		String result = builder.build();
		return result;
	}

	@Override
	public int compareTo(Service other)
	{
		CompareToBuilder builder = new CompareToBuilder().append(this.started, other.started)
				.append(this.description, other.description);
		int result = builder.build();
		return result;
	}

	@Override
	public boolean equals(Object otherObject)
	{
		boolean result;
		if (otherObject instanceof Service)
		{
			Service other = (Service) otherObject;
			EqualsBuilder builder = new EqualsBuilder().append(this.started, other.started)
					.append(this.description, other.description);
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
		HashCodeBuilder builder = new HashCodeBuilder().append(this.started)
				.append(this.description);
		int result = builder.build();
		return result;
	}
}
