package eu.glowacki.jaxrs.client.delayed.test;

import java.util.concurrent.Future;

import javax.ws.rs.client.InvocationCallback;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.jaxrs.client.delayed.CalculatorDelayed;
import eu.glowacki.jaxrs.client.delayed.proxy.CalculatorDelayedProxy;
import eu.glowacki.jaxrs.client.test.TestBase;

public final class CalculatorDelayedProxyTest extends TestBase {

	private CalculatorDelayed _sut;

	@Before
	public void before() {
		_sut = new CalculatorDelayedProxy();
	}

	@Test
	public void addDelayed() throws Throwable {
		int component1 = 2;
		int component2 = 2;
		int expected = component1 + component2;
		InvocationCallback<Integer> callback = new CalculatorDelayedProxyTestInvocationCallback(expected);
		Future<Integer> future = _sut.addDelayed(component1, component2, callback);
		while (!future.isDone()) {
			sleep(1000);
		}
		
		int sum = future.get();
		Assert.assertEquals(expected, sum);
	}
	
	@Test
	public void subtractDelayed() throws Throwable {
		int minuend = 2;
		int subtrahend = 2;
		int expected = minuend - subtrahend;
		InvocationCallback<Integer> callback = new CalculatorDelayedProxyTestInvocationCallback(expected);
		Future<Integer> future = _sut.addDelayed(minuend, subtrahend, callback);
		while (!future.isDone()) {
			sleep(1000);
		}
		
		int difference = future.get();
		Assert.assertEquals(expected, difference);
	}

	private static class CalculatorDelayedProxyTestInvocationCallback implements
			InvocationCallback<Integer> {

		private final int _expected;

		private CalculatorDelayedProxyTestInvocationCallback(int expected) {
			_expected = expected;
		}

		public void completed(Integer response) {
			Assert.assertEquals(_expected, (int)response);
		}

		public void failed(Throwable ex) {
		}
	}
}