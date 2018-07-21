package eu.glowacki.jaxrs.delayed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import eu.glowacki.jaxrs.WebServiceBase;
import eu.glowacki.jaxrs.delayed.tasks.CalculatorAddDelayedTask;
import eu.glowacki.jaxrs.delayed.tasks.CalculatorSubtractDelayedTask;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@Path("/calculator-delayed")
public class CalculatorDelayed extends WebServiceBase {

	@GET
	@Path("/add-delayed")
	@Produces("application/json")
	public void addDelayed( //
			@QueryParam("component1") int component1, //
			@QueryParam("component2") int component2, //
			@Suspended final AsyncResponse response) {
		CalculatorAddDelayedTask task = new CalculatorAddDelayedTask(response,
				component1, component2);
		submit(task);
	}

	@GET
	@Path("/subtract-delayed")
	@Produces("application/json")
	public void subtractDelayed(//
			@QueryParam("minuend") int minuend, //
			@QueryParam("subtrahend") int subtrahend, //
			@Suspended final AsyncResponse response) {
		CalculatorSubtractDelayedTask task = new CalculatorSubtractDelayedTask(
				response, minuend, subtrahend);
		submit(task);
	}
}