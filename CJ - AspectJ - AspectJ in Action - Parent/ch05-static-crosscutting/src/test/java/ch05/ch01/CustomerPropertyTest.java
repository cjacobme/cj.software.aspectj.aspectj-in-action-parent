package ch05.ch01;

import static org.assertj.core.api.Assertions.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class CustomerPropertyTest
{
	@Test
	public void addressNotification()
	{
		Customer customer = new Customer();
		customer.setAddress("oldAddress");
		final AtomicInteger counter = new AtomicInteger();
		customer.addPropertyChangeListener(new PropertyChangeListener()
		{

			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				assertThat(evt.getPropertyName()).as("property name").isEqualTo("address");
				assertThat(evt.getOldValue()).as("old value").isEqualTo("oldAddress");
				assertThat(evt.getNewValue()).as("new value").isEqualTo("newAddress");
				counter.incrementAndGet();
			}
		});
		customer.setAddress("newAddress");
		assertThat(counter.get()).as("counter value").isEqualTo(1);
	}
}
