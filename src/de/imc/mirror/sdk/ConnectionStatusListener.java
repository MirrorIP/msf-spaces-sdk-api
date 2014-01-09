package de.imc.mirror.sdk;

/**
 * Interface for listeners of connection status changes.
 * @author simon.schwantzer(at)im-c.de
 */
public interface ConnectionStatusListener {
	/**
	 * Handler called when the connection status changes.
	 * @param newStatus New connection status.
	 */
	public void connectionStatusChanged(ConnectionStatus newStatus);
}
