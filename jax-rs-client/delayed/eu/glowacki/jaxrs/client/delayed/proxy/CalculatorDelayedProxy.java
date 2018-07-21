package eu.glowacki.jaxrs.client.delayed.proxy;

import java.util.concurrent.Future;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.client.ProxyBase;
import eu.glowacki.jaxrs.client.delayed.CalculatorDelayed;

public final class CalculatorDelayedProxy extends ProxyBase implements CalculatorDelayed {

	private static final String BASE_URI = "http://" + HOST_PORT + "/jax-rs-server/calculator-delayed";

	public CalculatorDelayedProxy() {
		super(BASE_URI);
	}

	public Future<Integer> addDelayed(int component1, int component2, InvocationCallback<Integer> callback) {
		WebTarget method = getMethod("add-delayed");
		return method.queryParam("component1", "" + component1).queryParam("component2", "" + component2)
				.request(MediaType.APPLICATION_JSON_TYPE).async().get(callback);
	}

	public Future<Integer> subtractDelayed(int minuend, int subtrahend, InvocationCallback<Integer> callback) {
		WebTarget method = getMethod("subtract-delayed");
		return method.queryParam("minuend", "" + minuend).queryParam("subtrahend", "" + subtrahend)
				.request(MediaType.APPLICATION_JSON_TYPE).async().get(callback);
	}
}