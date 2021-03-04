package ch02.own;

public class Circle
		extends Shape
{
	private static final long serialVersionUID = 1L;

	private int radius;

	public Circle(Point position, int radius)
	{
		super(position);
		this.radius = radius;
	}

	public int getRadius()
	{
		return this.radius;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	@Override
	public Rectangle calculateExtension()
	{
		Point center = super.getPosition();
		int xCenter = center.getX();
		int yCenter = center.getY();
		Point ll = new Point(xCenter - this.radius, yCenter - this.radius);
		Point ur = new Point(xCenter + this.radius, yCenter + this.radius);
		Rectangle result = new Rectangle(ll, ur);
		return result;
	}

	@Override
	public String toString()
	{
		Point position = super.getPosition();
		String result = String.format(
				"circle center=[%03d, %03d], radius=%d",
				position.getX(),
				position.getY(),
				this.radius);
		return result;
	}
}
