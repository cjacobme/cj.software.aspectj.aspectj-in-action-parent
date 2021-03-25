package ch06.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public aspect HomeSecurityAspect
{
	private Logger logger = LogManager.getFormatterLogger();
	
	before() : execution( void Home.exit())
	{
		logger.info("Engaging");
	}
	
	after() : execution(void Home.enter())
	{
		logger.info("Disengaging");
	}
}
