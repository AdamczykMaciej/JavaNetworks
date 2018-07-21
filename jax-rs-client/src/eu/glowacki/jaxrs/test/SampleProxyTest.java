package eu.glowacki.jaxrs.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.proxy.api.Sample;
import eu.glowacki.jaxrs.proxy.impl.SampleProxy;

public class SampleProxyTest {

	private Sample _sut;
	
	@Before
	public void before() {
		_sut = new SampleProxy();
	}
	
	@Test
	public void request() {
		String response = _sut.reply("request");
		Assert.assertNotNull(response);
	}
}