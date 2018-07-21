package eu.glowacki.jaxrs.proxy.impl;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.proxy.api.Sample;
import eu.glowacki.ws.Common;

public final class SampleProxy extends ProxyBase implements Sample {
	
	private static final String BASE_URI = "http://" + Common.HOST_PORT + "/jax-rs-server/sample";
	
	public SampleProxy() {
		super(BASE_URI);
	}
	
	public String reply(String request) {
		WebTarget method = method("reply");
		String response = method
		    .path(request)
	        .request(MediaType.TEXT_PLAIN_TYPE)
	        .get(String.class);
		return response;
	}
}