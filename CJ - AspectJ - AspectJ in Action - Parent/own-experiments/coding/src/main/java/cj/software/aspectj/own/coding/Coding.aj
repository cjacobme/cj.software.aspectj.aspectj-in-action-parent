package cj.software.aspectj.own.coding;

public aspect Coding 
{
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
		: get(java.io.PrintStream System.out) && within(cj.software..*..*)
		: "illegal access to System.out";
	
}
