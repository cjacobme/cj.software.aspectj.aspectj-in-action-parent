package ch02.own;

public aspect Precedence
{
//	declare precedence: Boundary, UpdateCanvasListener;
	declare precedence: UpdateCanvasListener, Boundary;
}
