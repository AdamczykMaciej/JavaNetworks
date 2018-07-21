package eu.glowacki.jaxrs.delayed.tasks;

import javax.ws.rs.container.AsyncResponse;

import eu.glowacki.jaxrs.AsyncTaskBase;

public final class CalculatorAddDelayedTask extends AsyncTaskBase<Integer> {
	
	private static final int DELAY = 10000;
	
	private final int _component1;
	private final int _component2;
	
	public CalculatorAddDelayedTask(AsyncResponse response, int component1, int component2) {
		super(response);
		_component1 = component1;
		_component2 = component2;
	}

	public void run() {
		sleep(DELAY);
		int sum = _component1 + _component2;
		resumeResponse(sum);
	}
}