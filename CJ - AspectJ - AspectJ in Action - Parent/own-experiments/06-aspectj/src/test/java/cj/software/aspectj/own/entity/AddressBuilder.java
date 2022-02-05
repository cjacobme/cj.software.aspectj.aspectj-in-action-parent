package cj.software.aspectj.own.entity;

public class AddressBuilder
		extends Address.Builder
{
	public AddressBuilder()
	{
		super.withCity("Essen").withZip("45131").withStreet("Brüsseler Platz 1");
	}
}
