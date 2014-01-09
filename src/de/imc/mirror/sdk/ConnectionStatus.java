package de.imc.mirror.sdk;

/**
 * Enumeration for connection status.
 * @author simon.schwantzer(at)im-c.de
 */
public enum ConnectionStatus {
	/**
	 * The connection is established.
	 */
	ONLINE,
	
	/**
	 * The connection is not established.
	 */
	OFFLINE,
	
	/**
	 * The connection is pending, i.e., a connection is trying to be established or closed.
	 */
	PENDING,
	
	/**
	 * An error occurred trying to establish the connection.
	 * The connection is not established. 
	 */
	ERROR
}
