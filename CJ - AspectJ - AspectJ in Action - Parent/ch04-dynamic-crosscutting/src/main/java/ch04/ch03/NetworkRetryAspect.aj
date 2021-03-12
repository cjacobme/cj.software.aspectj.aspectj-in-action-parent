package ch04.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.channels.UnresolvedAddressException;

public aspect NetworkRetryAspect 
{
	private Logger logger = LogManager.getFormatterLogger();
	
	pointcut networkRetry() : call (@NetworkRetries * * (..));
	
	Object around() : networkRetry() 
	{
		UnresolvedAddressException first = null;
		for (int i = 0; i < 3; i++)
		{
			try
			{
				Object retval = proceed();
				logger.info("return to caller");
				return retval;
			}
			catch (UnresolvedAddressException exception)
			{
				logger.warn("attempt %d: exception caught", i);
				if (first == null)
				{
					first = exception;
				}
			}
		}
		logger.error("giving up...");
		throw first;
	}
}
