package eu.glowacki.jaxrs.chunked;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.glassfish.jersey.server.ChunkedOutput;

import eu.glowacki.jaxrs.WebServiceBase;
import eu.glowacki.jaxrs.chunked.tasks.ReplyChunkedTask;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

@Path("/chunked")
public final class SampleChunked extends WebServiceBase {

	@GET
	@Path("/reply-chunked/{request}")
	public ChunkedOutput<String> replyChunked(@PathParam("request") String request) {
		final ChunkedOutput<String> output = new ChunkedOutput<String>(String.class);
		ReplyChunkedTask task = new ReplyChunkedTask(output, request);
		submit(task);
		return output;
	}
}