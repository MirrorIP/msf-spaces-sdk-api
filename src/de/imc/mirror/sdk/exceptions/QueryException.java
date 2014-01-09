package de.imc.mirror.sdk.exceptions;

/**
 * Exception thrown if a query failed.
 * @author simon.schwantzer(at)im-c.de
 */
public class QueryException extends Exception {
	public enum Type {
		/**
		 * The query is invalid.
		 */
		BAD_REQUEST,
		/**
		 * The user is not allowed to access one or more of the requested entities.
		 */
		ACCESS_DENIED,
		/**
		 * The query failed, for example based on a time out or an interruption. 
		 */
		FAILURE;
	}
	
	private static final long serialVersionUID = 1L;
	private final Type type;

	public QueryException(Type type) {
		super();
		this.type = type;
	}
	
	public QueryException(Type type, String message) {
		super(message);
		this.type = type;
	}
	
	public QueryException(Type type, String message, Throwable e) {
		super(message, e);
		this.type = type;
	}
	
	/**
	 * Returns the type of the exception.
	 * @return Exception type as specified in {@link QueryException.Type}. 
	 */
	public Type getType() {
		return type;
	}
}
