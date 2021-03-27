package ch07.ch04;

import java.util.EventListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HeartBeatListener
		implements
		EventListener
{
	private Logger logger = LogManager.getFormatterLogger();

	public void beat()
	{
		this.logger.info("beat");
	}
}
