package cj.software.aspectj.own.mdc;

import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import cj.software.aspectj.own.mdc.entity.Contract;

public aspect CorrelationIdAspect
{
	private interface HasLogger
	{}
	
	declare parents:
		hasfield(Logger *) implements HasLogger;
	
	private pointcut hasLogger() 
	: within(HasLogger+);
	
	private pointcut notPrivateMethod() 
	: execution(!private * cj.software.aspectj.own.mdc.service..*(..));
	
	private pointcut methodWithContract(Contract contract)
	: execution( * *.*(Contract, ..))
	&& args(contract, ..);
	
	Object around(Contract contract) 
	: methodWithContract(contract) 
	&& notPrivateMethod()
	&& hasLogger()
	{
		String oldCorrelationId = MDC.get(Constants.CORRELATION_ID);
		try
		{
			String id = contract.getId().toString();
			MDC.put(Constants.CORRELATION_ID, id);
			Object result = proceed(contract);
			return result;
		}
		finally
		{
			MDC.put(Constants.CORRELATION_ID, oldCorrelationId);
		}
	}
}
