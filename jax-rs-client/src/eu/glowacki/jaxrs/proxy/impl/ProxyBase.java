package eu.glowacki.jaxrs.proxy.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import eu.glowacki.ws.Common;

public abstract class ProxyBase {
	
	protected static final String HOST_PORT = Common.HOST_PORT;
	
	private final String _baseUri;
	private final Client _client;
	
	protected ProxyBase(String baseUri) {
		configure();
		_baseUri = baseUri;
		_client = ClientBuilder.newClient();
	}
	
	protected Client getClient() {
		return _client;
	}
	
	protected WebTarget getTarget() {
		Client client = getClient();
		return client.target(_baseUri);
	}
	
	protected WebTarget method(String methodName) {
		WebTarget resource = getTarget();
		return resource.path(methodName);
	}
	
	private void configure() {
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "8888");
        
        // Dump raw messages to the console
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "" + true);
    }
}