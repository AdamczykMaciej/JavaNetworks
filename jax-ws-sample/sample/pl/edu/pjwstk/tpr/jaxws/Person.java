package pl.edu.pjwstk.tpr.jaxws;

import java.util.Comparator;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class Person {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(XMLGregorianCalendar	 dateOfBirth) {
		this.dateOfBirth = dateOfBirth.toGregorianCalendar().getTime();
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;

	}

	public String getLastName() {
		return this.lastName;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public static Comparator<Person> getCompByDateOfBirth() {
		Comparator comp = new Comparator<Person>() {
			@Override
			public int compare(Person s1, Person s2) {
//				System.out.println(s1.getDateOfBirth()+" "+s2.getDateOfBirth());
//				System.out.println(s1.getDateOfBirth().toGregorianCalendar().compareTo(s2.getDateOfBirth().toGregorianCalendar()));
//				return s1.getDateOfBirth().toGregorianCalendar().compareTo(s2.getDateOfBirth().toGregorianCalendar());
				return s1.getDateOfBirth().compareTo(s2.getDateOfBirth());
			}
		};
		return comp;
	}

	public static Comparator<Person> getCompByLastName() {
		Comparator comp = new Comparator<Person>() {
			@Override
			public int compare(Person s1, Person s2) {
//				System.out.println(s1.getLastName()+" "+s2.getLastName());
				return s1.getLastName().compareTo(s2.getLastName());
			}
		};
		return comp;
	}
}
