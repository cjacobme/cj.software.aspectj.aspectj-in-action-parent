package ch02.own;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Canvas
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private int width;

	private int height;

	private List<Shape> shapes = new ArrayList<>();

	public Canvas(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public boolean add(Shape shape)
	{
		boolean result = this.shapes.add(shape);
		if (result)
		{
			shape.setCanvas(this);
		}
		return result;
	}

	public boolean remove(Shape shape)
	{
		boolean result = this.shapes.remove(shape);
		if (result)
		{
			shape.setCanvas(null);
		}
		return result;
	}

	public Iterator<Shape> iterate()
	{
		return this.shapes.iterator();
	}

	public List<Shape> getShapes()
	{
		return Collections.unmodifiableList(this.shapes);
	}
}
