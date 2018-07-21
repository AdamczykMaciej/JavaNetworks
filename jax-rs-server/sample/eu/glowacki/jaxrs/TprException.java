package eu.glowacki.jaxrs;

public class TprException extends RuntimeException {

	private static final long serialVersionUID = -8366710958797049391L;

	public TprException(String message, Throwable cause) {
		super(message, cause);
	}
}