package ch02.own;

import java.util.ArrayList;
import java.util.List;

public aspect UpdateCanvasListener 
{
	public List<CanvasModifiedListener> Canvas.modifiedListeners = new ArrayList<>();
	
	after(Shape shape) : execution( void Shape+.set*(..))
	&& ! execution(void Shape+.setCanvas(Canvas))
	&& this(shape)
	{
		Canvas canvas = shape.getCanvas();
		if (canvas != null)
		{
			String action = thisJoinPoint.toLongString();
			CanvasModifiedEvent event = new CanvasModifiedEvent(action, shape);
			for (CanvasModifiedListener listener : canvas.modifiedListeners)
			{
				listener.notify(event);
			}
		}
	}
	
	after(Shape shape) : execution( * Canvas.add(Shape))
	&& args(shape)
	{
		Canvas canvas = shape.getCanvas();
		if (canvas != null)
		{
			String action = thisJoinPoint.toLongString();
			CanvasModifiedEvent event = new CanvasModifiedEvent(action, shape);
			for (CanvasModifiedListener listener : canvas.modifiedListeners)
			{
				listener.notify(event);
			}
		}
		else
		{
			System.err.println("no canvas for shape " + shape);
		}
	}
}
