package ch06.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Home
{
	private Logger logger = LogManager.getFormatterLogger();

	public void enter()
	{
		this.logger.info("entering");
	}

	public void exit()
	{
		this.logger.info("exiting");
	}
}
