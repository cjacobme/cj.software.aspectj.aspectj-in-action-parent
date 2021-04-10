package ch09.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "order")
@SequenceGenerator(name = "seqOrder", sequenceName = "seq_order", allocationSize = 1)
public class Order
{
	@Id
	@GeneratedValue(generator = "seqOrder")
	private Long id;

	@Version
	private int version;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	private Collection<LineItem> lineItems = new ArrayList<>();

	private boolean placed;

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
		return Collections.unmodifiableCollection(this.lineItems);
	}

	public void addItem(Product product, int quantity)
	{
		if (isPlaced())
		{
			throw new IllegalStateException("once placed, the order may not be modified");
		}
		LineItem found = getItemFor(product);
		if (found != null)
		{
			found.setQuantity(found.getQuantity() + quantity);
		}
		else
		{
			LineItem newItem = new LineItem(this, product, quantity);
			this.lineItems.add(newItem);
		}
	}

	public void removeItem(Product product, int quantity)
	{
		if (isPlaced())
		{
			throw new IllegalStateException("once placed, the order may not be modified");
		}
		LineItem found = getItemFor(product);
		if (found == null)
		{
			throw new IllegalArgumentException("No line item for product " + product + " found");
		}
		int currentQuantity = found.getQuantity();
		if (currentQuantity < quantity)
		{
			throw new IllegalArgumentException("removing more quantity than existing");
		}
		else if (currentQuantity == quantity)
		{
			this.lineItems.remove(found);
		}
		else
		{
			found.setQuantity(currentQuantity - quantity);
		}
	}

	private LineItem getItemFor(Product product)
	{
		LineItem result = null;
		for (LineItem checked : this.lineItems)
		{
			if (checked.getProduct().equals(product))
			{
				result = checked;
				break;
			}
		}
		return result;
	}
}
