package ch06.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class HomeTest
{
	private Logger logger = LogManager.getFormatterLogger();

	@Test
	public void exitAndEnter()
	{
		Home home = new Home();
		this.logger.info("bye");
		home.exit();
		this.logger.info("entering home now...");
		home.enter();
	}
}
