package eu.glowacki.jaxrs.client.chunked.proxy.test;

import org.glassfish.jersey.client.ChunkedInput;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.client.chunked.SampleChunked;
import eu.glowacki.jaxrs.client.chunked.proxy.SampleChunkedProxy;

public final class SampleChunkedProxyTest {
	
	private SampleChunked _sut;
	
	@Before
	public void before() {
		_sut = new SampleChunkedProxy();
	}

	@Test
	public void replyChunked() {
		final String request = "request";
		ChunkedInput<String> chunks = _sut.replyChunked(request);
		String chunk;
		int readCount = 0;
		System.err.println("BEFORE READING");
		while ((chunk = chunks.read()) != null) {
			readCount++;
			System.err.println(chunk);
		}
		System.err.println("READ COUNT: " + readCount);
	}
}