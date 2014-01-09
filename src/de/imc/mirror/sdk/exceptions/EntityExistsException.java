package de.imc.mirror.sdk.exceptions;

/**
 * Indicates thats an unique entity cannot be created because it already exists, e.g., a XMPP user.
 * @author simon.schwantzer(at)im-c.de
 */
public class EntityExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public EntityExistsException() {
		super();
	}
	
	public EntityExistsException(String message) {
		super(message);
	}
	
	public EntityExistsException(String message, Throwable e) {
		super(message, e);
	}
}
