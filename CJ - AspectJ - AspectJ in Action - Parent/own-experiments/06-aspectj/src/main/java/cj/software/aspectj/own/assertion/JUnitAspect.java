package cj.software.aspectj.own.assertion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class JUnitAspect
{
	private LogService logService = new LogService();

	@Pointcut("call (* org.junit.Assert.*(..))")
	public void junitAssert()
	{
	}

	@AfterReturning("junitAssert()")
	public void normalReturn(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		String message;
		if (args != null && args.length == 3 && args[0] instanceof String)
		{
			message = (String) args[0];
		}
		else
		{
			message = null;
		}
		this.logService.succeed(joinPoint.getSignature(), message);
	}

	@AfterThrowing(pointcut = "junitAssert()", throwing = "throwable")
	public void caughtThrowable(JoinPoint joinPoint, Throwable throwable)
	{
		this.logService.fail(joinPoint.getSignature(), throwable);
	}

}
