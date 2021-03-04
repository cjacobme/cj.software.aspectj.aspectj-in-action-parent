package ch02.own;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ensures that any change of a {@link Shape}s attributes keeps it in the boundaries of its
 * canvas.
 */
public aspect Boundary
{
	private Logger logger = LogManager.getFormatterLogger();
	
	after(Shape shape) : execution( void Shape+.set*(..))
	&& ! execution(void Shape+.setCanvas(Canvas))
	&& this(shape)
	{
		logger.info("Shape change %s", shape);
		Canvas canvas = shape.getCanvas();
		if (canvas != null)
		{
			Rectangle rectangle = shape.calculateExtension();
			Point lowerLeft = rectangle.getLowerLeft();
			Point upperRight = rectangle.getUpperRight();
			if (lowerLeft.getX() < 0
					|| lowerLeft.getY() < 0
					|| upperRight.getX() > canvas.getWidth()
					|| upperRight.getY() > canvas.getHeight())
			{
				String message = String.format("%s violated canvas width (%d), height (%d)",
						shape.toString(), canvas.getWidth(), canvas.getHeight());
				logger.warn("I'll throw an exception now...");
				throw new IllegalArgumentException(message);
			}
			logger.debug("ok");
		}
	}
}
