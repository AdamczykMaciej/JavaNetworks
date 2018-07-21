package eu.glowacki.jaxrs.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

public interface People {
	public static List<Person> people = new ArrayList<>();

	public String create(Person p);

	public void add(Person p);

	public String getPeople();

	public void clearPeople();

	public String query(String lastName, Date dateOfBirth);

	public List<Person> sortByDateOfBirth(List<Person> listOfPeople);

	public List<Person> sortByLastName(List<Person> listOfPeople);
}
