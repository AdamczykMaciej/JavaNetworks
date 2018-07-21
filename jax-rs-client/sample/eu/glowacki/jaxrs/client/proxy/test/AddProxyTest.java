package eu.glowacki.jaxrs.client.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.client.Add;
import eu.glowacki.jaxrs.client.proxy.AddProxy;

public final class AddProxyTest {

	private Add _sut;

	@Before
	public void before() {
		_sut = new AddProxy();
	}

	@Test
	public void add() {
		int component1 = 2;
		int component2 = 3;
		int sum = _sut.add(component1, component2);
		Assert.assertEquals(component1 + component2, sum);
	}
}