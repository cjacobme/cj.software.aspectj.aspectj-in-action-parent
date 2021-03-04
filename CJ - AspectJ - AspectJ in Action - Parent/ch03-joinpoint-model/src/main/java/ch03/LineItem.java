package ch03;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "line_item")
public class LineItem
		extends DomainEntity
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	@ManyToOne
	private Order order;

	private int quantity;
	private double unitPrice;

	private LineItem()
	{
	}

	public LineItem(Order order, Product product, int quantity)
	{
		this();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = product.getPrice();
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public int setQuantity(int quantity)
	{
		return this.quantity = quantity;
	}

	public Product getProduct()
	{
		return this.product;
	}

	public double getUnitPrice()
	{
		return this.unitPrice;
	}

	public double getLineTotal()
	{
		return getQuantity() * getUnitPrice();
	}

}
