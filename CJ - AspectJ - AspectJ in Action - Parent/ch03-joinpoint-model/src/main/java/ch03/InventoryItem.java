package ch03;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_item")
public class InventoryItem
		extends DomainEntity
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@OneToOne
	private Product product;

	private int quantityOnHand;

	private InventoryItem()
	{
	}

	public InventoryItem(Product product)
	{
		this();
		this.product = product;
	}

	public int getQuantityOnHand()
	{
		return this.quantityOnHand;
	}

	public void deplete(int quantity)
	{
		this.quantityOnHand -= quantity;
	}

	public void replenish(int quantity)
	{
		this.quantityOnHand += quantity;
	}
}
