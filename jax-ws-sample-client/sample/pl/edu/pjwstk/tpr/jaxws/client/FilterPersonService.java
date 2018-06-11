
package pl.edu.pjwstk.tpr.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FilterPersonService", targetNamespace = "http://jaxws.tpr.pjwstk.edu.pl/", wsdlLocation = "http://localhost:8080/jax-ws-sample/filterperson?wsdl")
public class FilterPersonService
    extends Service
{

    private final static URL FILTERPERSONSERVICE_WSDL_LOCATION;
    private final static WebServiceException FILTERPERSONSERVICE_EXCEPTION;
    private final static QName FILTERPERSONSERVICE_QNAME = new QName("http://jaxws.tpr.pjwstk.edu.pl/", "FilterPersonService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/jax-ws-sample/filterperson?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILTERPERSONSERVICE_WSDL_LOCATION = url;
        FILTERPERSONSERVICE_EXCEPTION = e;
    }

    public FilterPersonService() {
        super(__getWsdlLocation(), FILTERPERSONSERVICE_QNAME);
    }

    public FilterPersonService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILTERPERSONSERVICE_QNAME, features);
    }

    public FilterPersonService(URL wsdlLocation) {
        super(wsdlLocation, FILTERPERSONSERVICE_QNAME);
    }

    public FilterPersonService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILTERPERSONSERVICE_QNAME, features);
    }

    public FilterPersonService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FilterPersonService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FilterPerson
     */
    @WebEndpoint(name = "FilterPersonPort")
    public FilterPerson getFilterPersonPort() {
        return super.getPort(new QName("http://jaxws.tpr.pjwstk.edu.pl/", "FilterPersonPort"), FilterPerson.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FilterPerson
     */
    @WebEndpoint(name = "FilterPersonPort")
    public FilterPerson getFilterPersonPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://jaxws.tpr.pjwstk.edu.pl/", "FilterPersonPort"), FilterPerson.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILTERPERSONSERVICE_EXCEPTION!= null) {
            throw FILTERPERSONSERVICE_EXCEPTION;
        }
        return FILTERPERSONSERVICE_WSDL_LOCATION;
    }

}