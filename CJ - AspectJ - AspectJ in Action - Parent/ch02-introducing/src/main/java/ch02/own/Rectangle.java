package ch02.own;

import java.io.Serializable;

public class Rectangle
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private Point lowerLeft;

	private Point upperRight;

	public Rectangle(Point lowerLeft, Point upperRight)
	{
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
	}

	public Point getLowerLeft()
	{
		return this.lowerLeft;
	}

	public void setLowerLeft(Point lowerLeft)
	{
		this.lowerLeft = lowerLeft;
	}

	public Point getUpperRight()
	{
		return this.upperRight;
	}

	public void setUpperRight(Point upperRight)
	{
		this.upperRight = upperRight;
	}

}
