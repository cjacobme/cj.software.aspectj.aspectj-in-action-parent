package ch02.own;

import java.io.Serializable;

public class CanvasModifiedEvent
		implements
		Serializable

{
	private static final long serialVersionUID = 1L;

	private String action;

	private Shape shape;

	public CanvasModifiedEvent(String action, Shape shape)
	{
		super();
		this.action = action;
		this.shape = shape;
	}

	public String getAction()
	{
		return this.action;
	}

	public Shape getShape()
	{
		return this.shape;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("CanvasModifiedEvent [").append("action=")
				.append(this.action)
				.append("]");
		String result = sb.toString();
		return result;
	}
}
