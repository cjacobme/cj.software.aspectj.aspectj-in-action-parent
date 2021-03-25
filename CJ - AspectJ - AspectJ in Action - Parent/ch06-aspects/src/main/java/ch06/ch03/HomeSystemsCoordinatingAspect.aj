package ch06.ch03;


public aspect HomeSystemsCoordinatingAspect 
{
	declare precedence: HomeSecurityAspect, SaveEnergyAspect; 
}
