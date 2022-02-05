package cj.software.aspectj.own.assertion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HamcrestAspect
{
	private LogService logService = new LogService();

	@Pointcut("call (* org.hamcrest.MatcherAssert.assertThat(..))")
	public void hamcrestAssertion()
	{
	}

	@AfterReturning("hamcrestAssertion()")
	public void normalExecution(JoinPoint joinPoint)
	{
		this.logService.succeed(joinPoint);
	}

	@AfterThrowing(pointcut = "hamcrestAssertion()", throwing = "throwable")
	public void exceptionCaught(JoinPoint joinPoint, Throwable throwable)
	{
		this.logService.fail(joinPoint, throwable);
	}
}
