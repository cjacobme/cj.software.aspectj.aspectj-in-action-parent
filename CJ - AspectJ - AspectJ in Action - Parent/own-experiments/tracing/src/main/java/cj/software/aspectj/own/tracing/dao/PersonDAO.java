package cj.software.aspectj.own.tracing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cj.software.aspectj.own.tracing.entity.Person;

public class PersonDAO
{
	private Map<UUID, Person> persons = fillPersons();

	private static Map<UUID, Person> fillPersons()
	{
		Map<UUID, Person> result = new HashMap<>();
		result = put(
				result,
				new Person(
						UUID.fromString("8d59bb66-f31a-4581-a1ac-5cd59d7a7825"),
						"Christian",
						"Jacob"));
		result = put(
				result,
				new Person(
						UUID.fromString("8d59bb66-f31a-4581-a1ac-5cd59d7a7826"),
						"Barbara",
						"Jacob"));
		return result;
	}

	private static Map<UUID, Person> put(Map<UUID, Person> source, Person person)
	{
		Map<UUID, Person> result = source;
		result.put(person.getId(), person);
		return result;
	}

	public void add(Person person)
	{
		put(this.persons, person);
	}

	public List<Person> listPersons()
	{
		List<Person> result = new ArrayList<>();
		for (UUID uuid : this.persons.keySet())
		{
			Person person = this.persons.get(uuid);
			result.add(person);
		}
		return result;
	}
}
