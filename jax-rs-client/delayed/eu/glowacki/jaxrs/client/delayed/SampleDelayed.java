package eu.glowacki.jaxrs.client.delayed;

import java.util.concurrent.Future;

import javax.ws.rs.client.InvocationCallback;

public interface SampleDelayed {

	Future<String> replyDelayed(String request, InvocationCallback<String> callback);
}