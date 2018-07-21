package eu.glowacki.jaxrs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

@WebServlet( //
		urlPatterns = "/*", //
		initParams = { //
				@WebInitParam(name = "jersey.config.server.provider.packages", value = "eu.glowacki.jaxrs"), //
				@WebInitParam(name = "jersey.config.server.provider.scanning.recursive", value = "true"), //
				@WebInitParam(name = "org.glassfish.jersey.api.json.POJOMappingFeature", value = "true") //
		}, //
		asyncSupported = true)
public class WebServicePort extends ServletContainer {

	public void init() throws ServletException {
		super.init();
		final Application application = new ResourceConfig() //
				.packages("eu.glowacki.jaxrs") //
//				.register(MoxyJsonFeature.class) //
				.register(JacksonFeature.class);
			
				
				
	}

	private static final long serialVersionUID = -6946589644571530717L;
}