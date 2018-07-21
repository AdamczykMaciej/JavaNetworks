package eu.glowacki.jaxrs.person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.WebServiceBase;


@Path("/people")
public class People extends WebServiceBase{
	private static ArrayList<Person> people = new ArrayList<>(); 
	
	@Path("/create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(Person p) {
		people.add(p);
		return "Successful";
	}
	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Person p) {
		people.add(p);
	}
	
	@Path("/getPeople")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Person> getPeople(){
		return people;
	}
	
	@Path("/clearPeople")
	@GET
	public void clearPeople() {
		people.clear();
	}
	// streams for filtering
	
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Person query(@QueryParam("lastName")String lastName, Date dateOfBirth) {
		for(Person p: people) {
			if(p.getLastName().equals(lastName) && p.getDateOfBirth().equals(dateOfBirth)) {
				return p;
			}
		}
		return null;
	}
	

	public List<Person> sortByDateOfBirth(List<Person> listOfPeople) {
		Collections.sort(listOfPeople, Person.getCompByDateOfBirth());
//		System.out.println(listOfPeople.get(0).getDateOfBirth());
		return listOfPeople;
	}
	

	public List<Person> sortByLastName(List<Person> listOfPeople) {
		Collections.sort(listOfPeople, Person.getCompByLastName());
		return listOfPeople;
	}
}
