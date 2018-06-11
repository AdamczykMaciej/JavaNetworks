
package pl.edu.pjwstk.tpr.jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.pjwstk.tpr.jaxws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BubbleSortResponse_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "bubbleSortResponse");
    private final static QName _FilterByDateOfBirth_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "filterByDateOfBirth");
    private final static QName _BubbleSort_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "bubbleSort");
    private final static QName _FilterByLastNameResponse_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "filterByLastNameResponse");
    private final static QName _FilterByLastName_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "filterByLastName");
    private final static QName _FilterByDateOfBirthResponse_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "filterByDateOfBirthResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.pjwstk.tpr.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BubbleSort }
     * 
     */
    public BubbleSort createBubbleSort() {
        return new BubbleSort();
    }

    /**
     * Create an instance of {@link FilterByLastNameResponse }
     * 
     */
    public FilterByLastNameResponse createFilterByLastNameResponse() {
        return new FilterByLastNameResponse();
    }

    /**
     * Create an instance of {@link FilterByDateOfBirth }
     * 
     */
    public FilterByDateOfBirth createFilterByDateOfBirth() {
        return new FilterByDateOfBirth();
    }

    /**
     * Create an instance of {@link BubbleSortResponse }
     * 
     */
    public BubbleSortResponse createBubbleSortResponse() {
        return new BubbleSortResponse();
    }

    /**
     * Create an instance of {@link FilterByDateOfBirthResponse }
     * 
     */
    public FilterByDateOfBirthResponse createFilterByDateOfBirthResponse() {
        return new FilterByDateOfBirthResponse();
    }

    /**
     * Create an instance of {@link FilterByLastName }
     * 
     */
    public FilterByLastName createFilterByLastName() {
        return new FilterByLastName();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BubbleSortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.tpr.pjwstk.edu.pl/", name = "bubbleSortResponse")
    public JAXBElement<BubbleSortResponse> createBubbleSortResponse(BubbleSortResponse value) {
        return new JAXBElement<BubbleSortResponse>(_BubbleSortResponse_QNAME, BubbleSortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByDateOfBirth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.tpr.pjwstk.edu.pl/", name = "filterByDateOfBirth")
    public JAXBElement<FilterByDateOfBirth> createFilterByDateOfBirth(FilterByDateOfBirth value) {
        return new JAXBElement<FilterByDateOfBirth>(_FilterByDateOfBirth_QNAME, FilterByDateOfBirth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BubbleSort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.tpr.pjwstk.edu.pl/", name = "bubbleSort")
    public JAXBElement<BubbleSort> createBubbleSort(BubbleSort value) {
        return new JAXBElement<BubbleSort>(_BubbleSort_QNAME, BubbleSort.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByLastNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.tpr.pjwstk.edu.pl/", name = "filterByLastNameResponse")
    public JAXBElement<FilterByLastNameResponse> createFilterByLastNameResponse(FilterByLastNameResponse value) {
        return new JAXBElement<FilterByLastNameResponse>(_FilterByLastNameResponse_QNAME, FilterByLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByLastName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.tpr.pjwstk.edu.pl/", name = "filterByLastName")
    public JAXBElement<FilterByLastName> createFilterByLastName(FilterByLastName value) {
        return new JAXBElement<FilterByLastName>(_FilterByLastName_QNAME, FilterByLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByDateOfBirthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jaxws.tpr.pjwstk.edu.pl/", name = "filterByDateOfBirthResponse")
    public JAXBElement<FilterByDateOfBirthResponse> createFilterByDateOfBirthResponse(FilterByDateOfBirthResponse value) {
        return new JAXBElement<FilterByDateOfBirthResponse>(_FilterByDateOfBirthResponse_QNAME, FilterByDateOfBirthResponse.class, null, value);
    }

}
