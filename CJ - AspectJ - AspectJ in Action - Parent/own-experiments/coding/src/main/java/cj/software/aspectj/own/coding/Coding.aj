package cj.software.aspectj.own.coding;

public aspect Coding 
{
	pointcut systemout() : get(java.io.PrintStream System.out);
	
	pointcut listUsage() : set(!@ListUsageOk java.util.List *);
	
	pointcut listOfComparable() : set(java.util.List<java.lang.Comparable+> *);
	
	pointcut listAsParameter(): execution( * *.*(.., java.util.List, ..));
	
	declare warning
		: listAsParameter() && !within(Coding) && ! listOfComparable()
		: "java.util.List as parameter";
	
	declare warning
		: listUsage() && !within(Coding) && ! listOfComparable()
		: "possibly improper use of java.util.List";
	
	declare error
		: systemout()
		: "illegal access to System.out";
	
}
