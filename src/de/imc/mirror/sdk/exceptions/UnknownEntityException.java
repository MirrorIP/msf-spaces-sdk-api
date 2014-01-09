package de.imc.mirror.sdk.exceptions;

/**
 * Exception thrown when an unknown entity is addressed.
 * @author simon.schwantzer(at)im-c.de
 */
public class UnknownEntityException extends Exception {
	private static final long serialVersionUID = -4974959270382297946L;

	public UnknownEntityException(String message) {
		super(message);
	}
	
	public UnknownEntityException(String message, Throwable e) {
		super(message, e);
	}
}
