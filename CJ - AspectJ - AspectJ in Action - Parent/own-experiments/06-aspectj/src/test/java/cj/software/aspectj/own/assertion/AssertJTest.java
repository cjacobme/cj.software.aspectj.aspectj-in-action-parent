package cj.software.aspectj.own.assertion;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class AssertJTest
{
	@Test
	public void thisWillFail()
	{
		int number = 1;
		assertThat(number).as("number %d", number).isEqualTo(2);
	}

	@Test
	public void thisWillPass()
	{
		int number = 2;
		assertThat(number).as("this will %s", "pass").isEqualByComparingTo(2);
	}
}
