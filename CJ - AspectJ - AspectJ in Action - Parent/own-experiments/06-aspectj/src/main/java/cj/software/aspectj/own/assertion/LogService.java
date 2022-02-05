package cj.software.aspectj.own.assertion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.WritableAssertionInfo;

public class LogService
{
	private Logger logger = LogManager.getFormatterLogger();

	void succeed(JoinPoint joinPoint)
	{
		Signature signature = joinPoint.getSignature();
		Object target = joinPoint.getTarget();
		if (target instanceof AbstractAssert) // AssertJ
		{
			AbstractAssert<?, ?> abstractAssert = (AbstractAssert<?, ?>) target;
			WritableAssertionInfo info = abstractAssert.info;
			String text = info.descriptionText();
			this.logger.info("%s [%s] succeeded", signature, text);
		}
		else if (target == null) // JUnit
		{
			/*
			 * if there are three args and the first is a String, then this is the message
			 */
			Object[] args = joinPoint.getArgs();
			if (args != null && args.length == 3 && args[0] instanceof String)
			{
				String message = (String) args[0];
				this.logger.info("%s [%s] succeeded", signature, message);
			}
			else
			{
				this.logger.info("%s succeeded", signature);
			}
		}
		else
		{
			this.logger.info("%s succeeded", signature);
		}
	}

	void fail(JoinPoint joinPoint, Throwable throwable)
	{
		Signature signature = joinPoint.getSignature();
		this.logger.error("%s failed with %s", signature, throwable.getMessage());
	}
}
