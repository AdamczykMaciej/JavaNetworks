package eu.glowacki.jaxrs.proxy.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.glowacki.jaxrs.person.Person;
import eu.glowacki.jaxrs.proxy.PeopleProxy;

public class PeopleProxyTest {
	private PeopleProxy _sut;

	@Before
	public void before() throws ParseException, DatatypeConfigurationException {
		_sut = new PeopleProxy();
		_sut.clearPeople(); // clears all the data (because we check also nulls)
		// but for clearing we will get failures
	}

	@Test
	public void add() throws ParseException, DatatypeConfigurationException, JsonProcessingException {
		Person a = new Person();
		a.setFirstName("Maciej");
		a.setLastName("Adamczyk");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("1998-11-20");
		GregorianCalendar grc1 = new GregorianCalendar();
		grc1.setTime(d1);
		XMLGregorianCalendar gDateFormatted1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc1);
		a.setDateOfBirth(d1);
		// Gson gson = new Gson();
		// String json = gson.toJson(a);
		// ObjectMapper mapper = new ObjectMapper();
		// String json = mapper.writeValueAsString(a);
		// System.out.println(json);
		// json = json.replaceAll("\"", "");
		// json = json.replace("{", "");
		// json = json.replace("}", "");
		// String p = _sut.create(a);
		// System.out.println(p);
		// System.out.println(p.getLastName());
		// System.out.println(a.getLastName());
		_sut.add(a);
		System.out.println("List of People: " + _sut.getPeople());
	}

	@Test
	public void query() throws DatatypeConfigurationException, ParseException {

		String lastName = "Kowalski";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("1998-11-20");
		GregorianCalendar grc1 = new GregorianCalendar();
		grc1.setTime(d1);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc1);
		Person p1 = new Person();
		p1.setLastName(lastName);
		p1.setDateOfBirth(d1);
		String p = _sut.query(lastName, d1);
		System.out.println(p);
		// Assert.assertNull(p.getFirstName());
		_sut.add(p1);
		System.out.println("Added");
		p = _sut.query(lastName, d1);
		System.out.println("Query: " + p);
		// Assert.assertEquals(p.getLastName(), p1.getLastName());
		// Assert.assertEquals(p.getDateOfBirth(), p1.getDateOfBirth());
	}

	@Test
	public void getPeople() throws ParseException, DatatypeConfigurationException, JsonProcessingException {
		// Assert.assertTrue(_sut.getPeople().isEmpty());
		String firstName = "Marcin";
		String lastName = "Kowalski";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("1998-11-20");
		GregorianCalendar grc1 = new GregorianCalendar();
		grc1.setTime(d1);
		XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc1);
		Person p1 = new Person();
		p1.setFirstName(firstName);
		p1.setLastName(lastName);
		p1.setDateOfBirth(d1);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p1);
		_sut.add(p1);
		_sut.getPeople();
		// Assert.assertEquals(_sut.getPeople().get(0).getFirstName(),
		// p1.getFirstName());
		// Assert.assertEquals(_sut.getPeople().get(0).getLastName(), p1.getLastName());
		// Assert.assertEquals(_sut.getPeople().get(0).getDateOfBirth(),
		// p1.getDateOfBirth());

	}

	// @Test
	// public void filterByLastName() {
	// Person a = new Person();
	// Person b = new Person();
	// Person c = new Person();
	// a.setLastName("Adamczyk");
	// b.setLastName("Zebrakowski");
	// c.setLastName("Bednarek");
	// List<Person> list1 = new ArrayList<>(); // sorted manually
	// list1.add(a);
	// list1.add(c);
	// list1.add(b);
	// List<Person> list2 = new ArrayList<>();
	// list2.add(b);
	// list2.add(c);
	// list2.add(a);
	// list2 = _sut.sortByLastName(list2); // sorted by our method
	//
	// Assert.assertEquals(list1.get(0).getLastName(), list2.get(0).getLastName());
	// Assert.assertEquals(list1.get(1).getLastName(), list2.get(1).getLastName());
	// Assert.assertEquals(list1.get(2).getLastName(), list2.get(2).getLastName());
	// }
	//
	// @Test
	// public void filterByDateOfBirth() throws DatatypeConfigurationException,
	// ParseException {
	// Person a = new Person();
	// Person b = new Person();
	// Person c = new Person();
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// Date d1 = sdf.parse("1998-11-20");
	// Date d2 = sdf.parse("2000-10-10");
	// Date d3 = sdf.parse("2010-06-02");
	// GregorianCalendar grc1 = new GregorianCalendar();
	// grc1.setTime(d1);
	// XMLGregorianCalendar gDateFormatted1 =
	// DatatypeFactory.newInstance().newXMLGregorianCalendar(grc1);
	// GregorianCalendar grc2 = new GregorianCalendar();
	// grc2.setTime(d2);
	// XMLGregorianCalendar gDateFormatted2 =
	// DatatypeFactory.newInstance().newXMLGregorianCalendar(grc2);
	// GregorianCalendar grc3 = new GregorianCalendar();
	// grc3.setTime(d3);
	// XMLGregorianCalendar gDateFormatted3 =
	// DatatypeFactory.newInstance().newXMLGregorianCalendar(grc3);
	// a.setDateOfBirth(d1);
	// b.setDateOfBirth(d2);
	// c.setDateOfBirth(d3);
	// System.out.println(d1);
	// List<Person> list1 = new ArrayList<>(); // sorted manually
	// list1.add(a);
	// list1.add(b);
	// list1.add(c);
	// List<Person> list2 = new ArrayList<>();
	// list2.add(b);
	// list2.add(c);
	// list2.add(a);
	// list2 = _sut.sortByDateOfBirth(list2); // sorted by our method
	// Assert.assertEquals(list1.get(0).getDateOfBirth(),
	// list2.get(0).getDateOfBirth());
	// Assert.assertEquals(list1.get(1).getDateOfBirth(),
	// list2.get(1).getDateOfBirth());
	// Assert.assertEquals(list1.get(2).getDateOfBirth(),
	// list2.get(2).getDateOfBirth());
	// }

}
