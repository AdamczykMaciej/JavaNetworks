package pl.edu.pjwstk.tpr.jaxws.client.proxy;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.ws.developer.WSBindingProvider;

import pl.edu.pjwstk.tpr.jaxws.client.FilterPerson;
import pl.edu.pjwstk.tpr.jaxws.client.FilterPersonService;
import pl.edu.pjwstk.tpr.jaxws.client.Person;
import pl.edu.pjwstk.tpr.jaxws.client.common.ProxyBase;



public class FilterPersonProxy extends ProxyBase implements FilterPerson {

	private FilterPersonService _service;
	private FilterPerson _port;
	
	public void filterByLastName(ArrayList<Person> people) {
		getPort().filterByLastName(people);
		
	}
	
	protected WSBindingProvider getBindingProvider() {
		return (WSBindingProvider)getPort();
	}
	
	private FilterPerson getPort() {
		if (_service == null) {
			_service = new FilterPersonService();
		}
		if (_port == null) {
			_port = _service.getFilterPersonPort();
		}
		return _port;
	}

	@Override
	public void bubbleSort(List<Person> arg0) {
		getPort().bubbleSort(arg0);
		
	}

	@Override
	public List<Person> filterByLastName(List<Person> arg0) {
		return getPort().filterByLastName(arg0);
		
	}

	@Override
	public List<Person> filterByDateOfBirth(List<Person> arg0) {
		return getPort().filterByDateOfBirth(arg0);
	}
}