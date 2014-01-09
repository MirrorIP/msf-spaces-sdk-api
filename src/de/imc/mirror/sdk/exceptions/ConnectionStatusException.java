package de.imc.mirror.sdk.exceptions;

/**
 * Exception thrown when an operation is performed which is not available for the current
 * connection status.
 * @author simon.schwantzer(at)im-c.de
 */
public class ConnectionStatusException extends Exception {
	private static final long serialVersionUID = -2285853177173649306L;

	public ConnectionStatusException(String message) {
		super(message);
	}
	
	public ConnectionStatusException(String message, Throwable e) {
		super(message, e);
	}
}
