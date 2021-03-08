package cj.software.aspectj.own.tracing.service;

import java.util.List;

import cj.software.aspectj.own.tracing.aspect.NoTrace;
import cj.software.aspectj.own.tracing.aspect.Trace;
import cj.software.aspectj.own.tracing.dao.PersonDAO;
import cj.software.aspectj.own.tracing.entity.Person;

public class PersonService
{
	private PersonDAO dao;

	public PersonService()
	{
		this.dao = new PersonDAO();
	}

	@Trace
	public List<Person> listPersons(@NoTrace String searchName, String searchSurname)
	{
		List<Person> result = this.dao.listPersons();
		doNothing();
		return result;
	}

	@Trace
	public void doNothing()
	{

	}
}
