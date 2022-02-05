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
		if (target instanceof AbstractAssert)
		{
			AbstractAssert<?, ?> abstractAssert = (AbstractAssert<?, ?>) target;
			WritableAssertionInfo info = abstractAssert.info;
			String text = info.descriptionText();
			this.logger.info("%s [%s] succeeded", signature, text);
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
