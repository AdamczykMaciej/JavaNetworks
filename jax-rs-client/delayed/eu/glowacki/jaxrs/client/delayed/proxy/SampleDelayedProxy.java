package eu.glowacki.jaxrs.client.delayed.proxy;

import java.util.concurrent.Future;

import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.client.ProxyBase;
import eu.glowacki.jaxrs.client.delayed.SampleDelayed;

public final class SampleDelayedProxy extends ProxyBase implements SampleDelayed {
	
	private static final String BASE_URI = "http://" + HOST_PORT + "/jax-rs-server/sample";
	
	public SampleDelayedProxy() {
		super(BASE_URI);
	}
	
	public Future<String> replyDelayed(String request, InvocationCallback<String> callback) {
		WebTarget method = getMethod("reply");
		return method
		    .path(request)
	        .request(MediaType.TEXT_PLAIN_TYPE)
	        .async()
	        .get(callback);
	}
}