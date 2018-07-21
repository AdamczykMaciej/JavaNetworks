package eu.glowacki.jaxrs.client.delayed;

import java.util.concurrent.Future;

import javax.ws.rs.client.InvocationCallback;

public interface CalculatorDelayed {

	Future<Integer> addDelayed(int component1, int component2, InvocationCallback<Integer> callback);
	
	Future<Integer> subtractDelayed(int minuend, int subtrahend, InvocationCallback<Integer> callback);
}