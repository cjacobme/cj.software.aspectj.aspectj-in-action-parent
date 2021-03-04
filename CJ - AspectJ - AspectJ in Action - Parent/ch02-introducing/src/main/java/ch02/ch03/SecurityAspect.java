package ch02.ch03;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect
{
	private Authenticator authenticator = new Authenticator();

	@Pointcut("execution (* ch02.ch03.MessageCommunicator.deliver(..))")
	public void secureAccess()
	{
	}

	@Before("secureAccess()")
	public void secure()
	{
		System.out.println("Checking and authenticating user...");
		this.authenticator.authenticate();
	}
}
