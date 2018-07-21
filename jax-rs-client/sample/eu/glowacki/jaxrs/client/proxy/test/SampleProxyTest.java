package eu.glowacki.jaxrs.client.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.client.Sample;
import eu.glowacki.jaxrs.client.proxy.SampleProxy;

public final class SampleProxyTest {
	
	private Sample _sut;
	
	@Before
	public void before() {
		_sut = new SampleProxy();
	}

	@Test
	public void reply() {
		final String request = "request";
		String response = _sut.reply(request);
		final String expected = "Hello, " + request;
		Assert.assertEquals(expected, response);
	}
}