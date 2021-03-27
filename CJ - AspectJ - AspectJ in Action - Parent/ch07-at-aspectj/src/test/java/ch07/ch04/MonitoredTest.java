package ch07.ch04;

import org.junit.Test;

import ch07.ch04.impl.Monitored;

public class MonitoredTest
{
	@Test
	public void beatbeat()
	{
		Monitored instance = new Monitored();
		instance.monitorMe();
	}
}
