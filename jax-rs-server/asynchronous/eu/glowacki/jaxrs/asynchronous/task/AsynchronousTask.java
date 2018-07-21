package eu.glowacki.jaxrs.asynchronous.task;

import javax.ws.rs.container.AsyncResponse;

import eu.glowacki.jaxrs.TaskBase;
import eu.glowacki.jaxrs.TprException;

/**
 * @author Edgar Głowacki <edgar@glowacki.eu>
 */

public final class AsynchronousTask extends TaskBase<String> {

	private static final int DELAY = 5000;

	private final AsyncResponse _response;

	public AsynchronousTask(final AsyncResponse response) {
		_response = response;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(DELAY);
			_response.resume("ASYNCHRONOUS RESULT");
		} catch (Throwable exception) {
			throw new TprException("error occurred", exception);
		}
	}
}
