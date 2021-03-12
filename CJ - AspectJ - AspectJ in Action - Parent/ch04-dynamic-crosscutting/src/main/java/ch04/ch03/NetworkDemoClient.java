package ch04.ch03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetworkDemoClient
{
	private static Logger logger = LogManager.getFormatterLogger();

	public static void main(String[] args)
	{
		Service service = new Service();

		int retval = service.getReply();
		logger.info("Service replied %d", retval);
	}
}
