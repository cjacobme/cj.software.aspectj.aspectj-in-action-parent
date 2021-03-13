package cj.software.aspectj.own.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.slf4j.MDC;

public aspect CorrelationIdAspect 
{
	pointcut delegateExecution(DelegateExecution execution) 
	: execution( * *.*(.., DelegateExecution, ..))
	&& args(execution);
	
	pointcut delegateTask(DelegateTask task)
	: execution( * *.*(.., DelegateTask, ..))
	&& args(task);
	
	Object around(DelegateExecution execution) : delegateExecution(execution) 
	{
		String oldCorrelationId = MDC.get(VariableNames.CORRELATION_ID);
		try
		{
			String newCorrelationId = (String)execution.getVariable(VariableNames.CORRELATION_ID);
			MDC.put(VariableNames.CORRELATION_ID, newCorrelationId);
			Object retVal = proceed(execution);
			return retVal;
		}
		finally
		{
			MDC.put(VariableNames.CORRELATION_ID, oldCorrelationId);
		}
	}
	
	Object around (DelegateTask task) : delegateTask(task)
	{
		String oldCorrelationId = MDC.get(VariableNames.CORRELATION_ID);
		try
		{
			DelegateExecution execution = task.getExecution();
			String newCorrelationId = (String)execution.getVariable(VariableNames.CORRELATION_ID);
			MDC.put(VariableNames.CORRELATION_ID, newCorrelationId);
			Object retval = proceed(task);
			return retval;
		}
		finally
		{
			MDC.put(VariableNames.CORRELATION_ID, oldCorrelationId);
		}
		
	}
}
