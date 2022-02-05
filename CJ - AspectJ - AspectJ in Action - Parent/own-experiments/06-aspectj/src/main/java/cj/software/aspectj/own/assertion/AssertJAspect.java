package cj.software.aspectj.own.assertion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.WritableAssertionInfo;

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
		Object target = joinPoint.getTarget();
		String message;
		if (target instanceof AbstractAssert)
		{
			AbstractAssert<?, ?> abstractAssert = (AbstractAssert<?, ?>) target;
			WritableAssertionInfo info = abstractAssert.info;
			message = info.descriptionText();
		}
		else
		{
			message = "";
		}
		this.logService.succeed(joinPoint.getSignature(), message);
	}

	@AfterThrowing(pointcut = "assertionMethod() && !asMethod() && !extractingMethod()",
			throwing = "throwable")
	public void caughtThrowable(JoinPoint joinPoint, Throwable throwable)
	{
		this.logService.fail(joinPoint.getSignature(), throwable);
	}
}
