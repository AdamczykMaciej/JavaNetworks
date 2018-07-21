package eu.glowacki.jaxrs.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.proxy.api.Calculator;
import eu.glowacki.jaxrs.proxy.impl.CalculatorProxy;

public class CalculatorProxyTest {

	private Calculator _sut;

	@Before
	public void before() {
		_sut = new CalculatorProxy();
	}

	@Test
	public void add() {
		int result = _sut.add(20, 20);
		Assert.assertEquals(40, result);
	}
	
	@Test
	public void subtract() {
		int result = _sut.subtract(20, 10);
		Assert.assertEquals(10, result);
	}
}