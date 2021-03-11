package cj.software.aspectj.own.cflow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public aspect CflowAspect 
{
	private Logger logger = LogManager.getFormatterLogger("CflowAspect");
	
	pointcut control() : cflow(execution( * BillingMachine.calcTotalSum(..)))
							&& ! within(CflowAspect);
	
	before() : control() 
	{
		logger.info("%s", thisJoinPoint);
	}
}
