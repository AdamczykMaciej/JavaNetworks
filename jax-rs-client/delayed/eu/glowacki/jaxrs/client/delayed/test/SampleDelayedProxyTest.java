package eu.glowacki.jaxrs.client.delayed.test;

import java.util.concurrent.Future;

import javax.ws.rs.client.InvocationCallback;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.client.delayed.SampleDelayed;
import eu.glowacki.jaxrs.client.delayed.proxy.SampleDelayedProxy;
import eu.glowacki.jaxrs.client.test.TestBase;

public final class SampleDelayedProxyTest extends TestBase {
	
	private SampleDelayed _sut;

	@Before
	public void before() {
		_sut = new SampleDelayedProxy();
	}
	
	@Test
	public void replyDelayed() throws Throwable {
		String request = "request";
		InvocationCallback<String> callback = new SampleDelayedProxyTestInvocationCallback("Hello, " + request);
		Future<String> future = _sut.replyDelayed(request, callback);
		while (!future.isDone()) {
			sleep(1000);
		}
		String expected = "Hello, " + request;
		String response = future.get();
		Assert.assertEquals(expected, response);
	}
	
	private static class SampleDelayedProxyTestInvocationCallback implements InvocationCallback<String> {
		
		private final String _expected;
		
		private SampleDelayedProxyTestInvocationCallback(String expected) {
			_expected = expected;
		}

		public void completed(String response) {
			Assert.assertEquals(_expected, response);
		}

		public void failed(Throwable arg0) {
		}
	}
}