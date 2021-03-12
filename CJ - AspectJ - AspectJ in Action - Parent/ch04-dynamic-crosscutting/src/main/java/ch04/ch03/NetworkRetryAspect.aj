package ch04.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.nio.channels.UnresolvedAddressException;

public aspect NetworkRetryAspect 
{
	private Logger logger = LogManager.getFormatterLogger();
	
	pointcut networkRetry() : call (@NetworkRetries * * (..));
	
	Object around() : networkRetry() 
	{
		MethodSignature methodSignature = (MethodSignature)thisJoinPoint.getSignature();
		Method method = methodSignature.getMethod();
		NetworkRetries networkRetries = method.getAnnotation(NetworkRetries.class);
		int numTries = networkRetries.numTries();
		UnresolvedAddressException first = null;
		logger.info("totally %d tries...", numTries);
		for (int i = 0; i < numTries; i++)
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
