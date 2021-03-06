package cj.software.aspectj.own.coding;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OrderBy;

@Entity
public class MyEntity
{
	@OrderBy("name")
	private List<Person> persons = new ArrayList<>();

	public List<Person> getPersons()
	{
		return this.persons;
	}

}
