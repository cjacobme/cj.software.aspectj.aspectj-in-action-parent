package ch07.ch04;

import java.sql.Connection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ConnectionMonitor
{
	@Pointcut("call (* java.sql.Connection.*(..)) && target(connection)")
	public void connectionOperation(Connection connection)
	{
	}

	@Before("connectionOperation(connection)")
	public void monitorConnectionUsage(
			JoinPoint.StaticPart jpStatic,
			JoinPoint.EnclosingStaticPart jpEnclosing,
			Connection connection)
	{
		System.out.println(
				"about to use "
						+ connection
						+ " to perform "
						+ jpStatic.toShortString()
						+ " called from "
						+ jpEnclosing.toShortString());
	}
}
