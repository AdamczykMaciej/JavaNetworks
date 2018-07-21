package eu.glowacki.jaxrs.delayed.tasks;

import javax.ws.rs.container.AsyncResponse;

import eu.glowacki.jaxrs.AsyncTaskBase;

public final class CalculatorSubtractDelayedTask extends AsyncTaskBase<Integer> {
	
	private static final int DELAY = 10000;
	
	private final int _minuend;
	private final int _subtrahend;
	
	public CalculatorSubtractDelayedTask(AsyncResponse response, int minuend, int subtrahend) {
		super(response);
		_minuend = minuend;
		_subtrahend = subtrahend;
		_response.register(Integer.class);
	}

	public void run() {
		sleep(DELAY);
		int difference = _minuend + _subtrahend;
		resumeResponse(difference);
	}
}