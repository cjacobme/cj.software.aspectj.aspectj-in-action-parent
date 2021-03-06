package cj.software.aspectj.own.coding;

public aspect Coding 
{
	pointcut systemout() : get(java.io.PrintStream System.out);
	
	pointcut listUsage() : set(!@ListUsageOk java.util.List *);
	
	pointcut listOfComparable() : set(java.util.List<java.lang.Comparable+> *);
	
	declare warning
		: listUsage() && !within(Coding) && ! listOfComparable()
		: "possibly improper use of java.util.List";
	
	declare error
		: systemout()
		: "illegal access to System.out";
	
}
