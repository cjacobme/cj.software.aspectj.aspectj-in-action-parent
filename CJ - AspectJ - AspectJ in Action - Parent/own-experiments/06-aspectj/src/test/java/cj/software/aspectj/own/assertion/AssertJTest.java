package cj.software.aspectj.own.assertion;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import cj.software.aspectj.own.entity.Person;
import cj.software.aspectj.own.entity.PersonBuilder;

public class AssertJTest
{
	@Test
	public void thisWillFail()
	{
		int number = 1;
		assertThat(number).as("number %d", number).isEqualTo(2);
	}

	@Test
	public void thisWillPass()
	{
		int number = 2;
		assertThat(number).as("this will %s", "pass").isEqualByComparingTo(2);
	}

	@Test
	public void extractValues()
	{
		List<Person> persons = Arrays.asList(
				new PersonBuilder().build(),
				new PersonBuilder().withName("eins").build());
		//@formatter:off
		assertThat(persons).as("persons")
			.extracting("name", "birthday")
			.containsExactly(
					tuple("Karl Durchschnitt", LocalDate.of(1995, 10, 5)),
					tuple("eins", LocalDate.of(1995, 10, 5)));
		//@formatter:on
	}

	@Test
	public void softAssertions()
	{
		SoftAssertions softy = new SoftAssertions();
		softy.assertThat("Hello World").as("greeting").hasSize(11);
		softy.assertThat(3 * 4).as("product").isEqualTo(12);
		softy.assertAll();
	}
}
