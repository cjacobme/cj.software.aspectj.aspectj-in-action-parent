package ch02.own;

import java.io.Serializable;

public class Point
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private int x;

	private int y;

	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
}
