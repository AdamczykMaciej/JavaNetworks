package eu.glowacki.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Edgar G³owacki <edgar@glowacki.eu>
 */

//@Path("/calculator")
public class CalculatorService {

	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public int add(//
			@QueryParam("component1") int component1, //
			@QueryParam("component2") int component2) {
		int sum = component1 + component2;
		return sum;
	}

	@GET
	@Path("/subtract")
	@Produces(MediaType.APPLICATION_JSON)
	public int subtract(//
			@QueryParam("minuend") int minuend, //
			@QueryParam("subtrahend") int subtrahend) {
		int difference = minuend - subtrahend;
		return difference;
	}
}