package eu.glowacki.jaxrs.client.proxy;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import eu.glowacki.jaxrs.client.Add;
import eu.glowacki.jaxrs.client.ProxyBase;

public class AddProxy extends ProxyBase implements Add {

	private static final String BASE_URI = "http://" + HOST_PORT + "/jax-rs-server/add";

	public AddProxy() {
		super(BASE_URI);
	}

	@Override
	public int add(int component1, int component2) {
		WebTarget method = getMethod("add");
		int sum = method //
				.queryParam("component1", component1) //
				.queryParam("component2", component2) //
				.request(MediaType.TEXT_PLAIN_TYPE) //
				.get(Integer.TYPE);
		return sum;
	}
}