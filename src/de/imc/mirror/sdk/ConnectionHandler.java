package de.imc.mirror.sdk;

import de.imc.mirror.sdk.exceptions.ConnectionStatusException;
import de.imc.mirror.sdk.exceptions.EntityExistsException;

/**
 * A handler for XMPP connections.
 * The handler is designed to handle the XMPP connection for one specific user given during the initialization. 
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface ConnectionHandler {
	
	/**
	 * Returns the connection configuration.
	 * @return Current connection configuration. 
	 */
	public ConnectionConfiguration getConfiguration();
	
	/**
	 * Returns the connection status.
	 * @return Current connection status of this handler.
	 */
	public ConnectionStatus getStatus();
	
	/**
	 * Adds a listener to be notified when the connection status changes.
	 * @param listener Listener to add. 
	 */
	public void addConnectionStatusListener(ConnectionStatusListener listener);
	
	/**
	 * Removes a connection status listener.
	 * If the listener is not set, nothing will happen.
	 * @param listener Listener to remove.
	 */
	public void removeConnectionStatusListener(ConnectionStatusListener listener);
	
	/**
	 * Tries to establish a connection and perform the login.
	 * @throws ConnectionStatusException The connection could not be established.
	 */
	public void connect() throws ConnectionStatusException;
	
	/**
	 * Tries to establish a connection, create the configured user, and perform the login.
	 * @throws UnsupportedOperationException <code>createUser</code> is set to <code>true</code>, but the XMPP server does not support in-band registration.
	 * @throws EntityExistsException <code>createUser</code> is set to <code>true</code>, but a XMPP user account with the given username already exists.
	 * @throws ConnectionStatusException The connection could not be established.
	 */
	public void connectAndCreateUser() throws UnsupportedOperationException, EntityExistsException, ConnectionStatusException;
	
	/**
	 * Tries to disconnect from the XMPP server.
	 */
	public void disconnect();
	
	/**
	 * Returns the user information of the currently logged in user.
	 * @return User information.
	 */
	public UserInfo getCurrentUser();
	
	/**
	 * Returns information about the XMPP network the client is connected to.
	 * @return Information container object.
	 * @throws ConnectionStatusException The connection need to be established in order to request the information.
	 */
	public NetworkInformation getNetworkInformation() throws ConnectionStatusException;

}
