package eu.glowacki.jaxrs.delayed.tasks;

import javax.ws.rs.container.AsyncResponse;

import eu.glowacki.jaxrs.AsyncTaskBase;

public final class SampleReplyDelayedTask extends AsyncTaskBase<String> {
	
	private static final int DELAY = 10000;
	
	private final String _request; 
	
	public SampleReplyDelayedTask(AsyncResponse response, String request) {
		super(response);
		_request = request;
	}

	public void run () {
		sleep(DELAY);
		String response = "Hello, " + _request;
		resumeResponse(response);
	}
}