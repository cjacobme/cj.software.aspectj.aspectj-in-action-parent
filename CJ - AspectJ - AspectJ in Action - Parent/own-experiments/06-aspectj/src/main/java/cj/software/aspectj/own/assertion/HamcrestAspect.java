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

	@Pointcut("call (* org.hamcrest.MatcherAssert.assertThat(String, Object, org.hamcrest.Matcher))")
	public void matcherAssertWithReason()
	{
	}

	@Pointcut("call (* org.hamcrest.MatcherAssert.assertThat(Object, org.hamcrest.Matcher))")
	public void matcherAssertWithoutReason()
	{
	}

	@Pointcut("call (* org.hamcrest.MatcherAssert.assertThat(String, boolean))")
	public void plain()
	{
	}

	@AfterReturning("matcherAssertWithReason()")
	public void normalWithReason(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		String message = (String) args[0];
		this.logService.succeed(joinPoint.getSignature(), message);
	}

	@AfterReturning("matcherAssertWithoutReason()")
	public void normalWithoutReason(JoinPoint joinPoint)
	{
		this.logService.succeed(joinPoint.getSignature(), null);
	}

	@AfterReturning("plain()")
	public void normalPlain(JoinPoint joinPoint)
	{
		Object[] args = joinPoint.getArgs();
		String message = (String) args[0];
		this.logService.succeed(joinPoint.getSignature(), message);
	}

	@AfterThrowing(
			pointcut = "matcherAssertWithReason() || matcherAssertWithoutReason() || plain()",
			throwing = "throwable")
	public void exceptionCaught(JoinPoint joinPoint, Throwable throwable)
	{
		this.logService.fail(joinPoint.getSignature(), throwable);
	}
}
