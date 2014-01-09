package de.imc.mirror.sdk;

/**
 * Container for XMPP user information. 
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface UserInfo {
	/**
	 * Returns the XMPP username (aka node-id) of the user.
	 * The XMPP username is unique in an XMPP domain. 
	 * @return Username of the user.
	 */
	public String getUsername();
	
	/**
	 * Returns the XMPP domain the user is registered.
	 * @return XMPP domain string.
	 */
	public String getDomain();
	
	/**
	 * Returns the XMPP resource identifier of the client the user is connected with.
	 * @return XMPP resource string.
	 */
	public String getResource();
	
	/**
	 * Returns the bare-JID of the user.
	 * The bare-JID contains the node-id and domain string, e.g. "alice@mirror-demo.eu".
	 * @return Bare-JID as string.
	 */
	public String getBareJID();
	
	/**
	 * Returns the full JID of the user.
	 * Additionally to the bare-JID, the fill-JID also contains the resource identifier,
	 * e.g. "alice@mirror-demo.eu/myApp01".
	 * @return Full-JID as string.
	 */
	public String getFullJID();	
}
