package cj.software.aspectj.own.assertion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterReturning("assertionMethod() && !asMethod() && !extractingMethod()")
	public void normalReturn(JoinPoint joinPoint)
	{
		this.logService.succeed(joinPoint);
	}

	@AfterThrowing(pointcut = "assertionMethod() && !asMethod() && !extractingMethod()",
			throwing = "throwable")
	public void caughtThrowable(JoinPoint joinPoint, Throwable throwable)
	{
		this.logService.fail(joinPoint, throwable);
	}
}
