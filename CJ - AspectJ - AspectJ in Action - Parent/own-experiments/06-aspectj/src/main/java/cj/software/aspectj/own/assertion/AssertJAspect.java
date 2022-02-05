package cj.software.aspectj.own.assertion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AssertJAspect
{
	private Logger logger = LogManager.getFormatterLogger();

	@Pointcut("call(* org.assertj.core.api.*Assert.*(..))")
	public void assertionMethod()
	{
	}

	@Pointcut("call(* org.assertj.core.api.*Assert.as(..))")
	public void asMethod()
	{
	}

	@Pointcut("call(* org.assertj.core.api.*Assert.extracting(..))")
	public void extractingMethod()
	{
	}

	@Around("assertionMethod() && !asMethod() && !extractingMethod()")
	public Object logAssertion(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		try
		{
			Object result = joinPoint.proceed();
			this.logger.info("%s succeeded", signature);
			return result;
		}
		catch (Throwable throwable)
		{
			this.logger.error("%s failed %s", signature, throwable.getMessage());
			throw throwable;
		}
	}
}
