package ch09.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "line_item")
@SequenceGenerator(name = "seqLineItem", sequenceName = "seq_line_item", allocationSize = 1)
public class LineItem
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seqLineItem")
	private Long id;

	@Version
	private int version;

	@ManyToOne(cascade = CascadeType.ALL)
	@NotNull
	private Product product;

	@ManyToOne
	@NotNull
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

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public Product getProduct()
	{
		return this.product;
	}

	public Order getOrder()
	{
		return this.order;
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
