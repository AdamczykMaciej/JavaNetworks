package eu.glowacki.jaxrs.client.chunked.proxy;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ChunkedInput;

import eu.glowacki.jaxrs.client.ProxyBase;
import eu.glowacki.jaxrs.client.chunked.SampleChunked;
import eu.glowacki.ws.Common;

public final class SampleChunkedProxy extends ProxyBase implements SampleChunked {

	private static final String BASE_URI = "http://" + Common.HOST_PORT + "/jax-rs-server/chunked";

	public SampleChunkedProxy() {
		super(BASE_URI);
	}

	public ChunkedInput<String> replyChunked(String request) {
		WebTarget method = getMethod("reply-chunked");
		Response response = method //
				.path(request) //
				.request() //
				.get();
		GenericType<ChunkedInput<String>> chunkedInput = new StringGenericType();
		ChunkedInput<String> input = response //
				.readEntity(chunkedInput);
		return input;
	}
}