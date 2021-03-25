package ch06.ch03;

public aspect InterAdvicePrecedenceAspect
{
	public pointcut performCall() : call(* Performer.perform());
	
	after() returning : performCall()
	{
		System.out.println("<after1/>");
	}
	
	before(): performCall()
	{
		System.out.println("<before1/>");
	}
	
	void around() : performCall()
	{
		System.out.println("<around>");
		proceed();
		System.out.println("</around>");
	}
	
	before() : performCall()
	{
		System.out.println("<before2/>");
	}
}
