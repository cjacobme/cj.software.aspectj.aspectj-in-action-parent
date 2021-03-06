package cj.software.aspectj.own.coding;

import javax.persistence.Entity;
import javax.persistence.OrderBy;

public aspect Coding 
{
	pointcut systemout() : get(java.io.PrintStream System.out);
	
	pointcut entity(): set( * @Entity *.*);
	
	pointcut orderBy(): set( * *.*) && @annotation(OrderBy);
	
	pointcut listUsage() : set(!@ListUsageOk java.util.List *);
	
	pointcut listOfComparable() : set(java.util.List<java.lang.Comparable+> *);
	
	declare warning
		: !entity() && listUsage() && !within(Coding) && ! listOfComparable()
		: "possibly improper use of java.util.List";
	
	declare warning
		: entity() && listUsage() && ! orderBy()
		: "usage of java.util.List in Entity without @OrderBy";
	
	declare error
		: systemout()
		: "illegal access to System.out";
	
}
