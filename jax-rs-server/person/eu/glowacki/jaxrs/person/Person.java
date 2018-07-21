package eu.glowacki.jaxrs.person;

import java.util.Comparator;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
public class Person {
	// underscores very importanT!!, it is reflection
	private String _firstName;
	private String _lastName;
	private Date _dateOfBirth;

	public Person(){}

	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}

	public void setLastName(String lastName) {
		this._lastName = lastName;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this._dateOfBirth = dateOfBirth;
	}

//	public void setDateOfBirth(XMLGregorianCalendar dateOfBirth) {
//		this._dateOfBirth = dateOfBirth.toGregorianCalendar().getTime();
//	}

	public String getFirstName() {
		return this._firstName;

	}

	public String getLastName() {
		return this._lastName;
	}

	public Date getDateOfBirth() {
		return this._dateOfBirth;
	}

	public static Comparator<Person> getCompByDateOfBirth() {
		Comparator<Person> comp = new Comparator<Person>() {
			@Override
			public int compare(Person s1, Person s2) {
				// System.out.println(s1.getDateOfBirth()+" "+s2.getDateOfBirth());
				// System.out.println(s1.getDateOfBirth().toGregorianCalendar().compareTo(s2.getDateOfBirth().toGregorianCalendar()));
				// return
				// s1.getDateOfBirth().toGregorianCalendar().compareTo(s2.getDateOfBirth().toGregorianCalendar());
				return s1.getDateOfBirth().compareTo(s2.getDateOfBirth());
			}
		};
		return comp;
	}

	public static Comparator<Person> getCompByLastName() {
		Comparator<Person> comp = new Comparator<Person>() {
			@Override
			public int compare(Person s1, Person s2) {
				// System.out.println(s1.getLastName()+" "+s2.getLastName());
				return s1.getLastName().compareTo(s2.getLastName());
			}
		};
		return comp;
	}
}
