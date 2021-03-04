package ch02.own;

public class Line
		extends Shape
{
	private static final long serialVersionUID = 1L;

	private Point point2;

	public Line(Point position, Point point2)
	{
		super(position);
		this.point2 = point2;
	}

	public Point getPoint2()
	{
		return this.point2;
	}

	public void setPoint2(Point point2)
	{
		this.point2 = point2;
	}

	@Override
	public Rectangle calculateExtension()
	{
		Point position = super.getPosition();
		int x1 = position.getX();
		int y1 = position.getY();
		int x2 = this.point2.getX();
		int y2 = this.point2.getY();
		int xll = Math.min(x1, x2);
		int xur = Math.max(x1, x2);
		int yll = Math.min(y1, y2);
		int yur = Math.max(y1, y2);
		Rectangle result = new Rectangle(new Point(xll, yll), new Point(xur, yur));
		return result;
	}

	@Override
	public String toString()
	{
		Point position = super.getPosition();
		String result = String.format(
				"Line [%03d,%03d] -> [%03d,%03d]",
				position.getX(),
				position.getY(),
				this.point2.getX(),
				this.point2.getY());
		return result;
	}
}
