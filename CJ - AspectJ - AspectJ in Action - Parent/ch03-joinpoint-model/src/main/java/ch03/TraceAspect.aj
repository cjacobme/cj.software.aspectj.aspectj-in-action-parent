package ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public aspect TraceAspect 
{
	private int callDepth = 0;
	
	private Logger logger = LogManager.getFormatterLogger();
	
	pointcut traced() : !within(TraceAspect) ;
	
	before() : traced()
	{
		print("before " + thisJoinPoint);
		callDepth++;
	}
	
	after() : traced()
	{
		callDepth--;
		print("after " + thisJoinPoint);
	}
	
	private void print (String message)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < callDepth; i++)
		{
			sb.append("  ");
		}
		sb.append(message);
		logger.info(sb.toString());
	}
}
