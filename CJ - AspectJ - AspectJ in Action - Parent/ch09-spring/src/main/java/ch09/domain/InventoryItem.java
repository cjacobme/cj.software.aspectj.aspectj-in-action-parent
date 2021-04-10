package ch09.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "inventory_item")
@SequenceGenerator(name = "seqInventoryItem",
		sequenceName = "seq_inventory_item",
		allocationSize = 1)
public class InventoryItem
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seqInventoryItem")
	private Long id;

	@Version
	private int version;

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
