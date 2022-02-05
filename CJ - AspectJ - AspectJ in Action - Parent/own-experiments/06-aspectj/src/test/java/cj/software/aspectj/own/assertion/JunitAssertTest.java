package cj.software.aspectj.own.assertion;

import org.junit.Assert;
import org.junit.Test;

public class JunitAssertTest
{
	@Test
	public void fail()
	{
		Assert.assertEquals("will fail", 2L, 3L);
	}

	@Test
	public void failWithoutMessage()
	{
		Assert.assertEquals(3L, 4L);
	}

	@Test
	public void stringArrays()
	{
		Assert.assertArrayEquals(new String[]
		{ "Hello"
		}, new String[]
		{ "Hello", "World"
		});
	}

	@Test
	public void successLongs()
	{
		Assert.assertEquals("should suceed", 2l, 2l);
	}

	@Test
	public void successStringsWithoutMessage()
	{
		Assert.assertEquals("Hello", "Hello");
	}
}
