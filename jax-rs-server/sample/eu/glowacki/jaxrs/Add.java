package eu.glowacki.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@Path("/add")
public class Add extends WebServiceBase {

	@GET
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public int add(//
			@QueryParam("component1") int component1, //
			@QueryParam("component2") int component2) {
		int sum = component1 + component2;
		return sum;
	}
}