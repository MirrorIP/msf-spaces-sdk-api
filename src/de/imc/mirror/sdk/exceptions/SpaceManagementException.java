package de.imc.mirror.sdk.exceptions;

/**
 * Exception thrown if an error occurs during space creation, modification or deletion. 
 * @author simon.schwantzer(at)im-c.de
 *
 */
public class SpaceManagementException extends Exception {
	private static final long serialVersionUID = -1947324458133497707L;

	public enum Type {
		ALREADY_EXISTS,
		CONFIGURATION_ERROR,
		NOT_AUTHORIZED,
		OTHER
	}
	
	private final Type type;
	
	public SpaceManagementException(String message, Type type) {
		super(message);
		this.type = type;
	}
	
	public SpaceManagementException(String message, Type type, Throwable e) {
		super(message, e);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

}
