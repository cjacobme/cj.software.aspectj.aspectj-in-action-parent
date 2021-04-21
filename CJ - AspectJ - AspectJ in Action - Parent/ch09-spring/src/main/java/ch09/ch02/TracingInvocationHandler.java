package ch09.ch02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TracingInvocationHandler
		implements
		InvocationHandler
{
	private Object target;

	private Logger logger = LogManager.getFormatterLogger();

	public TracingInvocationHandler(Object target)
	{
		this.target = Objects.requireNonNull(target);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		this.logger.info("Entering %s", method);
		Object result = method.invoke(this.target, args);
		return result;
	}

}
