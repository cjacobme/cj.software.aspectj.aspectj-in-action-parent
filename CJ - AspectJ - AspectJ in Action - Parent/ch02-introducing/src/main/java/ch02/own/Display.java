package ch02.own;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Display
		implements
		CanvasModifiedListener
{
	private Logger logger = LogManager.getFormatterLogger();

	@Override
	public void notify(CanvasModifiedEvent event)
	{
		this.logger.info("%s %s", event.getAction(), event.getShape());
	}
}
