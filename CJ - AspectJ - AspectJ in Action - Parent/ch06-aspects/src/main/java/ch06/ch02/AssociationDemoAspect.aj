package ch06.ch02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public aspect AssociationDemoAspect
{
	private Logger logger = LogManager.getFormatterLogger();
	
	public AssociationDemoAspect()
	{
		logger.info("Creating aspect instance");
	}
	
	pointcut accountOperationExecution (Account account)
	: (execution( * Account.credit(..)) || execution(* Account.debit(..)))
	&& this(account);
	
	before(Account account)
	: accountOperationExecution(account)
	{
		logger.info("Joinpoint: %s\n\taspect: %s\n\tobject: %s", thisJoinPoint, this,account);
	}
}
