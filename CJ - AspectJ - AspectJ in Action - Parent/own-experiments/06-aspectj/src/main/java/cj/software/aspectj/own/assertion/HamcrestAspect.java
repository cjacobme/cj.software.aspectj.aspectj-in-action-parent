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
		Object[] args = joinPoint.getArgs();
		String message;
		if (args != null)
		{
			if (args.length == 3 && args[0] instanceof String)
			{
				message = (String) args[0];
			}
			else if (args.length == 2 && args[0] instanceof String && args[1] instanceof Boolean)
			{
				message = (String) args[0];
			}
			else
			{
				message = null;
			}
		}
		else
		{
			message = null;
		}
		this.logService.succeed(joinPoint.getSignature(), message);
	}

	@AfterThrowing(pointcut = "hamcrestAssertion()", throwing = "throwable")
	public void exceptionCaught(JoinPoint joinPoint, Throwable throwable)
	{
		this.logService.fail(joinPoint.getSignature(), throwable);
	}
}
