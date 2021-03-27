package cj.software.aspectj.own.mdc.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Contract
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private UUID id;

	private Party serviceProvider;

	private Party customer;

	private String title;

	private SortedSet<Service> services = new TreeSet<>();

	public Contract(UUID id, Party serviceProvider, Party customer, String title)
	{
		super();
		this.id = id;
		this.serviceProvider = serviceProvider;
		this.customer = customer;
		this.title = title;
	}

	public UUID getId()
	{
		return this.id;
	}

	public Party getServiceProvider()
	{
		return this.serviceProvider;
	}

	public Party getCustomer()
	{
		return this.customer;
	}

	public String getTitle()
	{
		return this.title;
	}

	public SortedSet<Service> getServices()
	{
		return Collections.unmodifiableSortedSet(this.services);
	}

	public boolean addService(Service service)
	{
		boolean result = this.services.add(service);
		return result;
	}

	@Override
	public String toString()
	{
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("customer", this.customer != null ? this.customer.getName() : null)
				.append(
						"provider",
						this.serviceProvider != null ? this.serviceProvider.getName() : null)
				.append("title", this.title);
		String result = builder.build();
		return result;
	}
}
