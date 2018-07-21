package eu.glowacki.jaxrs.asynchronous;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import eu.glowacki.jaxrs.WebServiceBase;
import eu.glowacki.jaxrs.asynchronous.task.AsynchronousTask;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@Path("/asynchronous")
public final class SampleAsynchronous extends WebServiceBase {

	@GET
	@Path("/reply-asynchronous")
	@Produces("text/plain")
	public void replyAsynchronous(@Suspended final AsyncResponse response) {
		AsynchronousTask task = new AsynchronousTask(response);
		submit(task);
	}
}