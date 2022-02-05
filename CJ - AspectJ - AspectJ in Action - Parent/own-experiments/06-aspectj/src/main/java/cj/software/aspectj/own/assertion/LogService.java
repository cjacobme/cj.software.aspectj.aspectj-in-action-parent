package cj.software.aspectj.own.assertion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class LogService
{
	private Logger logger = LogManager.getFormatterLogger();

	void succeed(JoinPoint joinPoint)
	{
		Signature signature = joinPoint.getSignature();
		this.logger.info("%s succeeded", signature);
	}

	void fail(JoinPoint joinPoint, Throwable throwable)
	{
		Signature signature = joinPoint.getSignature();
		this.logger.error("%s failed %s", signature, throwable.getMessage());
	}
}
