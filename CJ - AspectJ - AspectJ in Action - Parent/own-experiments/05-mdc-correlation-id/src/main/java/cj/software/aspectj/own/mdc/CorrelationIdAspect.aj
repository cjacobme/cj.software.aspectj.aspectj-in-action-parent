package cj.software.aspectj.own.mdc;

import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import cj.software.aspectj.own.mdc.entity.Contract;

public aspect CorrelationIdAspect
{
	private pointcut hasLogger() 
	: get( Logger *.*);
	
	private pointcut notPrivateMethod() 
	: execution(!private * cj.software.aspectj.own.mdc.service..*(..));
	
	private pointcut methodWithContract(Contract contract)
	: execution( * *.*(.., Contract, ..))
	&& args(contract);
	
	private pointcut toBeEmbedded(Contract contract) 
	: hasLogger() && notPrivateMethod() && methodWithContract(contract);
	
	Object around(Contract contract) : methodWithContract(contract) && notPrivateMethod()
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
