package ch07.ch04.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Monitored
{
	private Logger logger = LogManager.getFormatterLogger();

	public void monitorMe()
	{
		this.logger.info("monitor me");
	}
}
