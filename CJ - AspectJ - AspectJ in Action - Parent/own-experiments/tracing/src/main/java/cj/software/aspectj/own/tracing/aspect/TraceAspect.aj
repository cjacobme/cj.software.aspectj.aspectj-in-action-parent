package cj.software.aspectj.own.tracing.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public aspect TraceAspect 
{
	private pointcut trace() : execution(@Trace  * *.*(..));
	
	before() : trace() 
	{
		Logger logger = LogManager.getFormatterLogger(thisJoinPoint.getTarget().getClass());
		logger.info(thisJoinPoint.toLongString());
	}
}
