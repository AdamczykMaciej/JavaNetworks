package eu.glowacki.jaxrs.proxy;


import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.XMLGregorianCalendar;

import eu.glowacki.jaxrs.client.ProxyBase;
import eu.glowacki.jaxrs.person.People;
import eu.glowacki.jaxrs.person.Person;
import eu.glowacki.ws.Common;

public class PeopleProxy extends ProxyBase implements People {

	private static final String BASE_URI = "http://" + Common.HOST_PORT + "/jax-rs-server/people";
	
	public PeopleProxy() {
		super(BASE_URI);
	}

	@Override
	public void add(Person p) {
		WebTarget method = getMethod("add");
		method.request(MediaType.APPLICATION_JSON).post(Entity.json(p));
	}

	@Override
	public String getPeople() {
		WebTarget method = getMethod("getPeople");
		String response = method
				.request()
				.get(String.class);
		
		System.out.println(response);
		System.out.println(response);
		return response;
	}

	@Override
	public void clearPeople() {
		WebTarget method = getMethod("clearPeople");
	}

	@Override
	public List<Person> sortByDateOfBirth(List<Person> listOfPeople) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> sortByLastName(List<Person> listOfPeople) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String query(String lastName, Date dateOfBirth) {
		WebTarget method = getMethod("query");
		String response = method
				.queryParam("lastName",lastName)
				.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.post(Entity.json(dateOfBirth), String.class);
		return response;
	}

	@Override
	public String create(Person p) {
		Person person = new Person();
		person.setFirstName("Maciej");
		person.setLastName("Adamczyk");
		WebTarget method = getMethod("create");
		String response = method.request(MediaType.APPLICATION_JSON).accept(MediaType.TEXT_PLAIN).post(Entity.json(person),String.class);
		return response;
	}

}
