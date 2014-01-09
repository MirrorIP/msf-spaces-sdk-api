package de.imc.mirror.sdk;

/**
 * Model for information about the XMPP network and its components.
 * @author simon.schwantzer(at)im-c.de
 */
public interface NetworkInformation {
	/**
	 * Returns the version of the MIRROR Spaces Service.
	 * @return Version information string as provided by the service.
	 */
	public String getSpacesServiceVersion();
	
	/**
	 * Returns the JID of the MIRROR Spaces Service.
	 * @return JID of the XMPP component.
	 */
	public String getSpacesServiceJID();
	
	/**
	 * Returns the JIs of the MIRROR Persistence Service registered in the network.
	 * @return JID which address the XMPP component of a persistence service or <code>null</code> if no persistence service is registered.
	 */
	public String getPersistenceServiceJID();
}
