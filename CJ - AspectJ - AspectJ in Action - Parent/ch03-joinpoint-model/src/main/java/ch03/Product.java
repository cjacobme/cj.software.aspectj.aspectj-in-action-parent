package ch03;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product
		extends DomainEntity
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private double price;

	public Product()
	{
	}

	public Product(String name, String description, double price)
	{
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getPrice()
	{
		return this.price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Product: " + this.name;
	}

	@Override
	public int hashCode()
	{
		return 31 + ((this.name == null) ? 0 : this.name.hashCode());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}
		Product other = (Product) obj;
		if (this.name == other.name || (this.name != null && this.name.equals(other.name)))
		{
			return true;
		}
		return false;
	}

}
