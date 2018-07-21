package eu.glowacki.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;

public final class Application extends ResourceConfig {

	public Application() {
		packages("eu.glowacki.jaxrs");
		register(JacksonFeature.class);
	}
}
