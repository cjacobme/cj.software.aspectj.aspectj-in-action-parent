package ch06.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public aspect SaveEnergyAspect
{
	private Logger logger = LogManager.getFormatterLogger();
	
	before() : execution (void Home.exit())
	{
		logger.info("switching off lights");
	}
	
	after() : execution (void Home.enter())
	{
		logger.info("switching on lights");
	}
}
