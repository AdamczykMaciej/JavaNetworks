package pl.edu.pjwstk.tpr.jaxws.client.proxy.test;

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

import pl.edu.pjwstk.tpr.jaxws.client.FilterPerson;
import pl.edu.pjwstk.tpr.jaxws.client.Person;
import pl.edu.pjwstk.tpr.jaxws.client.proxy.FilterPersonProxy;

public class PersonProxyText {
	
	private FilterPerson _sut;
	
	@Before
	public void before() {
		_sut = new FilterPersonProxy();
	}

	@Test
	public void filterByLastName() {
		Person a = new Person();
		Person b = new Person();
		Person c = new Person();
		a.setLastName("Adamczyk");
		b.setLastName("Zebrakowski");
		c.setLastName("Bednarek");
		List<Person> list1 = new ArrayList<>(); // sorted manually
		list1.add(a);
		list1.add(c);
		list1.add(b);
		List<Person> list2 = new ArrayList<>();
		list2.add(b);
		list2.add(c);
		list2.add(a);
		list2 = _sut.filterByLastName(list2); // sorted by our method
		
		Assert.assertEquals(list1.get(0).getLastName(), list2.get(0).getLastName());
		Assert.assertEquals(list1.get(1).getLastName(), list2.get(1).getLastName());
		Assert.assertEquals(list1.get(2).getLastName(), list2.get(2).getLastName());
	}
	
	@Test
	public void filterByDateOfBirth() throws DatatypeConfigurationException, ParseException {
		Person a = new Person();
		Person b = new Person();
		Person c = new Person();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("1998-11-20");
		Date d2 = sdf.parse("2000-10-10");
		Date d3 = sdf.parse("2010-06-02");
		GregorianCalendar grc1 = new GregorianCalendar();
		grc1.setTime(d1);
		XMLGregorianCalendar gDateFormatted1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc1);
		GregorianCalendar grc2 = new GregorianCalendar();
		grc2.setTime(d2);
		XMLGregorianCalendar gDateFormatted2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc2);
GregorianCalendar grc3 = new GregorianCalendar();
grc3.setTime(d3);
XMLGregorianCalendar gDateFormatted3 = DatatypeFactory.newInstance().newXMLGregorianCalendar(grc3);
		a.setDateOfBirth(gDateFormatted1);
		b.setDateOfBirth(gDateFormatted2);
		c.setDateOfBirth(gDateFormatted3);
		System.out.println(d1);
		List<Person> list1 = new ArrayList<>(); // sorted manually
		list1.add(a);
		list1.add(b);
		list1.add(c);
		List<Person> list2 = new ArrayList<>();
		list2.add(b);
		list2.add(c);
		list2.add(a);
		list2 = _sut.filterByDateOfBirth(list2); // sorted by our method
		Assert.assertEquals(list1.get(0).getDateOfBirth(), list2.get(0).getDateOfBirth());
		Assert.assertEquals(list1.get(1).getDateOfBirth(), list2.get(1).getDateOfBirth());
		Assert.assertEquals(list1.get(2).getDateOfBirth(), list2.get(2).getDateOfBirth());
	}
}