package cj.software.aspectj.own.coding;

public aspect Coding 
{
	declare error
		: get(java.io.PrintStream System.out) && within(cj.software..*..*)
		: "illegal access to System.out";
	
}
