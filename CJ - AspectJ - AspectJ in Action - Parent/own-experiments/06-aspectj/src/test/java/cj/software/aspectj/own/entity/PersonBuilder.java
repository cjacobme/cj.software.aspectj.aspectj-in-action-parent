package cj.software.aspectj.own.entity;

import java.time.LocalDate;

public class PersonBuilder
		extends Person.Builder
{
	public PersonBuilder()
	{
		super.withName("Karl Durchschnitt").withBirthday(LocalDate.of(1995, 10, 5))
				.withAddress(new AddressBuilder().build());
	}
}
