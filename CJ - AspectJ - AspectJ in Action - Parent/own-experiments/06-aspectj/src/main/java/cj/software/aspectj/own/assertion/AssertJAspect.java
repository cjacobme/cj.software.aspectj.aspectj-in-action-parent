package cj.software.aspectj.own.assertion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AssertJAspect
{
	private LogService logService = new LogService();

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
		try
		{
			Object result = joinPoint.proceed();
			this.logService.succeed(joinPoint);
			return result;
		}
		catch (Throwable throwable)
		{
			this.logService.fail(joinPoint, throwable);
			throw throwable;
		}
	}
}
