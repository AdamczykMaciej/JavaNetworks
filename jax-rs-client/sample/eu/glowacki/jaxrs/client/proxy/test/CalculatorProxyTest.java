package eu.glowacki.jaxrs.client.proxy.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.client.Calculator;
import eu.glowacki.jaxrs.client.proxy.CalculatorProxy;

public final class CalculatorProxyTest {
	
	private Calculator _sut;
	
	@Before
	public void before() {
		_sut = new CalculatorProxy();
	}

	@Test
	public void add() {
		int component1 = 2;
		int component2 = 3;
		int sum = _sut.add(component1, component2);
		Assert.assertEquals(component1 + component2, sum);
	}
	
	@Test
	public void subtract() {
		int minuend = 5;
		int subtrahend = 3;
		int difference = _sut.subtract(minuend, subtrahend);
		Assert.assertEquals(minuend - subtrahend, difference);
	}
}