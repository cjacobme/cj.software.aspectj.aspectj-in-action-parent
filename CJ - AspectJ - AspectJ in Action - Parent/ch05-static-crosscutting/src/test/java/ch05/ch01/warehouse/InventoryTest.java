package ch05.ch01.warehouse;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class InventoryTest
{
	@Test
	public void removeFromInventory()
	{
		Inventory inventory = new Inventory("Book about Aspect-J");
		inventory.setAmount(5);
		inventory.addPropertyChangeListener(new PropertyChangeListener()
		{

			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				SoftAssertions softy = new SoftAssertions();
				softy.assertThat(evt.getPropertyName()).as("property name").isEqualTo("amount");
				softy.assertThat(evt.getOldValue()).as("old value").isEqualTo("5");
				softy.assertThat(evt.getNewValue()).as("new value").isEqualTo(3);
				softy.assertAll();
			}
		});
		inventory.withdraw(2);
	}
}
