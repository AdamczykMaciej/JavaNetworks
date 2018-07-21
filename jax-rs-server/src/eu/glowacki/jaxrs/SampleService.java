package eu.glowacki.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path("/sample")
public class SampleService {

	@GET
	@Path("/reply/{request}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response reply(@PathParam("request") String request) {
		String output = "Jersey response : '" + request + "'";
		return Response.status(200).entity(output).build();
	}
}