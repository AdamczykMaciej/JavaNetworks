package eu.glowacki.jaxrs.client.chunked;

import org.glassfish.jersey.client.ChunkedInput;

public interface SampleChunked {

	ChunkedInput<String> replyChunked(String request);
}