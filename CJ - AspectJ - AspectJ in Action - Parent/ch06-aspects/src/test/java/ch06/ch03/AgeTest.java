package ch06.ch03;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class AgeTest
{
	@Test
	public void performAge()
	{
		Age age = new Age();
		assertThat(age.getValue()).as("value").isEqualTo(32);
	}
}
