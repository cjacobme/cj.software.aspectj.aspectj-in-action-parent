package ch02.own;

public class GraphicalEditor
{
	public static void main(String[] args)
	{
		Display display = new Display();
		Canvas canvas = new Canvas(200, 400);
		canvas.modifiedListeners.add(display);
		Line line1 = new Line(new Point(13, 14), new Point(25, 33));
		Line line2 = new Line(new Point(133, 333), new Point(87, 92));
		Circle circle = new Circle(new Point(122, 222), 25);
		canvas.add(line1);
		canvas.add(line2);
		canvas.add(circle);

		circle.setRadius(35);
		line1.setPosition(new Point(55, 66));
		circle.setPosition(new Point(2, 2));
	}
}
