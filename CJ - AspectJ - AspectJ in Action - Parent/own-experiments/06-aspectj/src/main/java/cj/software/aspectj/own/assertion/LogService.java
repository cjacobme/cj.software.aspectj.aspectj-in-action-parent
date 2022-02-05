package cj.software.aspectj.own.assertion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.Signature;

public class LogService
{
	private Logger logger = LogManager.getFormatterLogger();

	void succeed(Signature signature, String message)
	{
		if (message != null && !message.isEmpty())
		{
			this.logger.info("%s [%s] succeeded", signature, message);
		}
		else
		{
			this.logger.info("%s succeeded", signature);
		}
	}

	void fail(Signature signature, Throwable throwable)
	{
		this.logger.error("%s failed with %s", signature, throwable.getMessage());
	}
}
