package eu.glowacki.jaxrs.delayed;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

import eu.glowacki.jaxrs.WebServiceBase;
import eu.glowacki.jaxrs.delayed.tasks.SampleReplyDelayedTask;

/**
 * @author Edgar G³owacki <edgar@glowacki.eu>
 */

@Path("sample-delayed")
public class SampleDelayed extends WebServiceBase {

	@GET
	@Path("/reply-delayed/{request}")
	@Produces("text/plain")
	public void replyDelayed(@PathParam("request") String request, @Suspended final AsyncResponse response) {
		SampleReplyDelayedTask task = new SampleReplyDelayedTask(response, request);
		submit(task);
	}
}