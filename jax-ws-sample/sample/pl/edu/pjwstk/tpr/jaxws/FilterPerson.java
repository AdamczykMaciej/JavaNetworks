package pl.edu.pjwstk.tpr.jaxws;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import pl.edu.pjwstk.tpr.jaxws.ports.WebServiceBase;

@WebService
public class FilterPerson extends WebServiceBase {
	
	@WebMethod
	public void bubbleSort(Person[] array) {
		boolean swapped = true;
		int j = 0;
		Person tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < array.length - j; i++) {
				if (array[i].getLastName().compareTo(array[i + 1].getLastName()) < 0) {
					tmp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}

	 
	
	
	@WebMethod
	public List<Person> filterByDateOfBirth(List<Person> listOfPeople) {
		Collections.sort(listOfPeople, Person.getCompByDateOfBirth());
//		System.out.println(listOfPeople.get(0).getDateOfBirth());
		return listOfPeople;
	}
	
	@WebMethod
	public List<Person> filterByLastName(List<Person> listOfPeople) {
		Collections.sort(listOfPeople, Person.getCompByLastName());
		return listOfPeople;
	}
	//
	// @WebMethod
	// public void filterByDateOfBirth(List<Person> listOfPeople) {
	// Collections.sort(listOfPeople, getCompByDateOfBirth());
	// }
}
