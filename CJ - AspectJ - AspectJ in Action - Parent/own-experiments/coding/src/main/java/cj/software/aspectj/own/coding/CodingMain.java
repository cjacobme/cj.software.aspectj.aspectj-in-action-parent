package cj.software.aspectj.own.coding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CodingMain
{
	private static List<String> strings = new ArrayList<>();

	private static List<Person> persons = new ArrayList<>();

	@ListUsageOk
	private static List<Person> annotatedPersons = new ArrayList<>();

	private static Logger logger = LogManager.getFormatterLogger();

	public static void main(String[] args)
	{
		logger.info("strings %d", strings.size());
		logger.info("persons %d", persons.size());
	}

	public void protocol(LocalDate ld, List<Person> persons, String abc)
	{
	}
}
