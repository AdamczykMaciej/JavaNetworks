package eu.glowacki.jaxrs.chunked.tasks;

import org.glassfish.jersey.server.ChunkedOutput;

import eu.glowacki.jaxrs.TaskBase;
import eu.glowacki.jaxrs.TprException;

public final class ReplyChunkedTask extends TaskBase<String> {

	private static final int RESPONSE_CHUNK_COUNT = 1000;
	private static final int DELAY = 10;

	private final String _request;
	private final ChunkedOutput<String> _output;

	public ReplyChunkedTask(final ChunkedOutput<String> output, String request) {
		_request = request;
		_output = output;
	}

	public void run() {
		try {
			for (int i = 0; i < RESPONSE_CHUNK_COUNT; i++) {
				String response = "RESPONSE " + i + ": " + _request + "\n";
				write(response);
				Thread.sleep(DELAY);
			}
		} catch (Throwable exception) {
			throw new TprException("error occured", exception);
		} finally {
			close();
		}
	}

	private void write(String message) {
		try {
			_output.write(message);
		} catch (Throwable exception) {
			throw new TprException("error occured", exception);
		}
	}

	private void close() {
		try {
			if (_output != null) {
				_output.close();
				System.err.println("OUTPUT CLOSED");
			}
		} catch (Throwable exception) {
			throw new TprException("error occured", exception);
		}
	}
}