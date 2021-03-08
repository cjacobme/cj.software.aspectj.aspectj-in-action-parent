package cj.software.aspectj.own.tracing.service;

import org.junit.BeforeClass;
import org.junit.Test;

public class PersonServiceTest
{
	private static PersonService personService;

	@BeforeClass
	public static void createPersonService()
	{
		personService = new PersonService();
	}

	@Test
	public void listPersons()
	{
		personService.listPersons("asdf", "qwer");
	}
}
