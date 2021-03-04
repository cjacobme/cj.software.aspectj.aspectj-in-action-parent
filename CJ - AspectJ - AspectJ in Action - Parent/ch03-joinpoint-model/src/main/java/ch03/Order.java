package ch03;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order
		extends DomainEntity
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	private Collection<LineItem> lineItems = new ArrayList<LineItem>();

	private boolean placed;

	public void addItem(Product product, int quantity)
	{
		if (isPlaced())
		{
			throw new IllegalStateException("Once placed, the order may not be modified");
		}
		LineItem lineItem = getItemFor(product);

		if (lineItem != null)
		{
			lineItem.setQuantity(lineItem.getQuantity() + quantity);
		}
		else
		{
			lineItem = new LineItem(this, product, 1);
			lineItem.setQuantity(quantity);
			this.lineItems.add(lineItem);
		}
	}

	public void removeItem(Product product, int quantity)
	{
		if (isPlaced())
		{
			throw new IllegalStateException("Once placed, the order may not be modified");
		}

		LineItem lineItem = getItemFor(product);

		if (lineItem == null)
		{
			throw new IllegalArgumentException("Failed to get line item");
		}
		int currentQuantity = lineItem.getQuantity();
		if (currentQuantity < quantity)
		{
			throw new IllegalArgumentException("Removing more quantity than present");
		}
		if (currentQuantity == quantity)
		{
			this.lineItems.remove(lineItem);
		}
		lineItem.setQuantity(currentQuantity - quantity);
	}

	public boolean isPlaced()
	{
		return this.placed;
	}

	public void place()
	{
		this.placed = true;
	}

	public void cancel()
	{
		this.placed = false;
	}

	public Collection<LineItem> getLineItems()
	{
		return new ArrayList<LineItem>(this.lineItems);
	}

	public double getTotalPrice()
	{
		double totalPrice = 0;
		for (LineItem lineItem : getLineItems())
		{
			totalPrice += lineItem.getLineTotal();
		}
		return totalPrice;
	}

	private LineItem getItemFor(Product product)
	{
		for (LineItem lineItem : this.lineItems)
		{
			if (lineItem.getProduct().equals(product))
			{
				return lineItem;
			}
		}
		return null;
	}

}
