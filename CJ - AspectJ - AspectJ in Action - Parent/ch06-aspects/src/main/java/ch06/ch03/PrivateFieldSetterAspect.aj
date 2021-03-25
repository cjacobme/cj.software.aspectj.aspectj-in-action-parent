package ch06.ch03;

privileged public aspect PrivateFieldSetterAspect
{
	
	after(Age age) : initialization(public Age.new()) && target(age)
	{
		age.value = 32;
	}
}
