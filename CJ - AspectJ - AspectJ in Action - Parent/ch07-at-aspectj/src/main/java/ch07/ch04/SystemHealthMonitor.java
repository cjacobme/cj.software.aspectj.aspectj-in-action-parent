package ch07.ch04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemHealthMonitor
{
	private HeartBeatListener heartBeatListener = new HeartBeatListener();

	@Pointcut("execution(* *.*(..)) && !within(ch07.ch04.*)")
	public void aliveOperation()
	{
	}

	@Before("aliveOperation()")
	public void beatHeart(JoinPoint joinPoint)
	{
		this.heartBeatListener.beat();
	}
}
