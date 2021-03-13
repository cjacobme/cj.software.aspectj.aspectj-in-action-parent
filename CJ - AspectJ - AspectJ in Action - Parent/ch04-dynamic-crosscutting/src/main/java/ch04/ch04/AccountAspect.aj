package ch04.ch04;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public aspect AccountAspect 
{
	Logger logger = LogManager.getFormatterLogger();
	
	pointcut creditOperation(Account account, double amount) 
	: call (void  Account.credit(double))
	&& target(account)
	&& args(amount);
	
	before(Account account, double amount) : creditOperation(account, amount) 
	{
		logger.info("crediting %s with %7.2f", account, amount);
	}
}
