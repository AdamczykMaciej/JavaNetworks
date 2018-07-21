package eu.glowacki.jaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import eu.glowacki.ws.Common;

public abstract class ProxyBase {
	
	protected static final String HOST_PORT = Common.HOST_PORT;
	
	private final String _baseUri;
	private final Client _client;
	
	protected ProxyBase(String baseUri) {
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
	
	protected WebTarget getMethod(String methodName) {
		WebTarget resource = getTarget();
		return resource.path(methodName);
	}
}