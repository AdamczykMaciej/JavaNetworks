package eu.glowacki.jaxrs;

public abstract class TaskBase<TResult> implements Runnable {

	protected final void sleep(int millis) throws TprException {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ex) {
			throw new TprException("error occurred", ex);
		}
	}
}