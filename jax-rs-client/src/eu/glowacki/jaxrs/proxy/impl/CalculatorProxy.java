package eu.glowacki.jaxrs.proxy.impl;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.AddResponse;
import eu.glowacki.jaxrs.proxy.api.Calculator;

public final class CalculatorProxy extends ProxyBase implements Calculator {
	
	private static final String BASE_URI = "http://" + HOST_PORT + "/jax-rs-server/calculator";
	
	public CalculatorProxy() {
		super(BASE_URI);
	}

	public int add(int component1, int component2) {
		WebTarget method = method("add");
		AddResponse response = method
		    .queryParam("component1", "" + component1)
		    .queryParam("component2", "" + component2)
		    .request(MediaType.APPLICATION_JSON_TYPE)
		    .get(AddResponse.class);
		return response.getResult();
	}

	public int subtract(int minuend, int subtrahend) {
		WebTarget method = method("subtract");
		int difference = method
		    .queryParam("minuend", "" + minuend)
		    .queryParam("subtrahend", "" + subtrahend)
		    .request(MediaType.APPLICATION_JSON_TYPE)
		    .get(Integer.TYPE);
		return difference;
	}
}