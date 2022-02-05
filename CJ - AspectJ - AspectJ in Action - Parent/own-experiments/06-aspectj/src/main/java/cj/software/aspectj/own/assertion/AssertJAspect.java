package cj.software.aspectj.own.assertion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AssertJAspect
{

	@Pointcut("call(* org.assertj.core.api.*Assert.*(..))")
	public void assertionMethod()
	{
	}

	@Pointcut("call(* org.assertj.core.api.*Assert.as(..))")
	public void asMethod()
	{
	}

	@Around("assertionMethod() && !asMethod()")
	public Object logAssertion(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		try
		{
			Object result = joinPoint.proceed();
			System.out.println(String.format("%s succeeded", signature));
			return result;
		}
		catch (Throwable throwable)
		{
			System.err.println(String.format("%s failed %s", signature, throwable.getMessage()));
			throw throwable;
		}
	}
}
