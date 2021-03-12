package ch04.ch03;

import java.nio.channels.UnresolvedAddressException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Service
{
	private Logger logger = LogManager.getFormatterLogger();

	@NetworkRetries(numTries = 8)
	public int getReply()
	{
		double randomNumber = Math.random();
		if (randomNumber > 0.25)
		{
			this.logger.error("throw because of %5.2g", randomNumber);
			throw new UnresolvedAddressException();
		}
		this.logger.info("return 5");
		return 5;
	}
}
