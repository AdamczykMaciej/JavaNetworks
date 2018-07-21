package eu.glowacki.jaxrs.client.test;

import eu.glowacki.jaxrs.client.TprException;


public class TestBase {

	protected void sleep(int millis) throws TprException {
    	try {
			Thread.sleep(millis);
		} catch (InterruptedException ex) {
			throw new TprException("error occurred", ex);
		}
    }
}