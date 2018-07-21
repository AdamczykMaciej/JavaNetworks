package eu.glowacki.jaxrs.client.proxy;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.client.Calculator;
import eu.glowacki.jaxrs.client.ProxyBase;

public final class CalculatorProxy extends ProxyBase implements Calculator {
	
	private static final String BASE_URI = "http://" + HOST_PORT + "/jax-rs-server/calculator";
	
	public CalculatorProxy() {
		super(BASE_URI);
	}

	public int add(int component1, int component2) {
		WebTarget method = getMethod("add");
		CalculatorResponse response = method
		    .queryParam("component1", "" + component1)
		    .queryParam("component2", "" + component2)
		    .request(MediaType.APPLICATION_JSON_TYPE)
		    .get(CalculatorResponse.class);
		return response.getResult();
	}

	public int subtract(int minuend, int subtrahend) {
		WebTarget method = getMethod("subtract");
		CalculatorResponse response = method
		    .queryParam("minuend", "" + minuend)
		    .queryParam("subtrahend", "" + subtrahend)
		    .request(MediaType.APPLICATION_JSON_TYPE)
		    .get(CalculatorResponse.class);
		return response.getResult();
	}
}