package ch02.own;

import java.io.Serializable;

public abstract class Shape
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private Point position;

	private Canvas canvas;

	protected Shape(Point position)
	{
		this.position = position;
	}

	public Canvas getCanvas()
	{
		return this.canvas;
	}

	public void setCanvas(Canvas canvas)
	{
		this.canvas = canvas;
	}

	public Point getPosition()
	{
		return this.position;
	}

	public void setPosition(Point position)
	{
		this.position = position;
	}

	public abstract Rectangle calculateExtension();
}
