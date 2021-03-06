
package pl.edu.pjwstk.tpr.jaxws.client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FilterPerson", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FilterPerson {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<pl.edu.pjwstk.tpr.jaxws.client.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "filterByDateOfBirth", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.FilterByDateOfBirth")
    @ResponseWrapper(localName = "filterByDateOfBirthResponse", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.FilterByDateOfBirthResponse")
    @Action(input = "http://jaxws.tpr.pjwstk.edu.pl/FilterPerson/filterByDateOfBirthRequest", output = "http://jaxws.tpr.pjwstk.edu.pl/FilterPerson/filterByDateOfBirthResponse")
    public List<Person> filterByDateOfBirth(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Person> arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "bubbleSort", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.BubbleSort")
    @ResponseWrapper(localName = "bubbleSortResponse", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.BubbleSortResponse")
    @Action(input = "http://jaxws.tpr.pjwstk.edu.pl/FilterPerson/bubbleSortRequest", output = "http://jaxws.tpr.pjwstk.edu.pl/FilterPerson/bubbleSortResponse")
    public void bubbleSort(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Person> arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<pl.edu.pjwstk.tpr.jaxws.client.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "filterByLastName", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.FilterByLastName")
    @ResponseWrapper(localName = "filterByLastNameResponse", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", className = "pl.edu.pjwstk.tpr.jaxws.client.FilterByLastNameResponse")
    @Action(input = "http://jaxws.tpr.pjwstk.edu.pl/FilterPerson/filterByLastNameRequest", output = "http://jaxws.tpr.pjwstk.edu.pl/FilterPerson/filterByLastNameResponse")
    public List<Person> filterByLastName(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Person> arg0);

}
