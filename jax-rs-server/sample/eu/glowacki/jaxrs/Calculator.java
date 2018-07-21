package eu.glowacki.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@Path("/calculator")
public final class Calculator extends WebServiceBase {
	

	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public CalculatorResponse add(//
			@QueryParam("component1") int component1, //
			@QueryParam("component2") int component2) {
		int sum = component1 + component2;
		CalculatorResponse response = new CalculatorResponse();
		response.setResult(sum);
		return response;
	}

	@GET
	@Path("/subtract")
	@Produces(MediaType.APPLICATION_JSON)
	public CalculatorResponse subtract(//
			@QueryParam("minuend") int minuend, //
			@QueryParam("subtrahend") int subtrahend) {
		int difference = minuend - subtrahend;
		CalculatorResponse response = new CalculatorResponse();
		response.setResult(difference);
		return response;
	}
}