package cj.software.aspectj.own.assertion;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class HamcrestTest
{
	@Test
	public void intsSucceed()
	{
		assertThat(13, equalTo(13));
	}

	@Test
	public void intsSucceedWithMessage()
	{
		assertThat("sum", 11 + 4, equalTo(15));
	}

	@Test
	public void intsFail()
	{
		assertThat("sum", 11 + 4, equalTo(111));
	}

	@Test
	public void plainFail()
	{
		assertThat("plain", false);
	}

	@Test
	public void plainSuccess()
	{
		assertThat("plain", true);
	}
}
