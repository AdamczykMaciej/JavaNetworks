package eu.glowacki.jaxrs;

import javax.ws.rs.container.AsyncResponse;

public abstract class AsyncTaskBase<TResult> extends TaskBase<TResult> {

	protected final AsyncResponse _response;

	protected AsyncTaskBase(AsyncResponse response) {
		_response = response;
	}
	
	protected void resumeResponse(TResult result) {
		_response.resume(result);
	}
}