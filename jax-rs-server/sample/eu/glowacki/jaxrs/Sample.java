package eu.glowacki.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@Path("/sample")
public class Sample extends WebServiceBase {

	@GET
	@Path("/reply/{request}")
	@Produces("text/plain")
	public String reply(//
			@PathParam("request") String request) {
		String response = "Hello, " + request;
		return response;
	}
}