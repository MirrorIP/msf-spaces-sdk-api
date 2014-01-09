package de.imc.mirror.sdk.config;

/**
 * List of namespaces used in the SDK implementation.
 * @author simon.schwantzer(at)im-c.de
 */
public interface NamespaceConfig {
	public String SPACES_SERVICE = "urn:xmpp:spaces";
	public String SPACES_SERVICE_CONFIG = "urn:xmpp:spaces:config";
	public String PERSISTENCE_SERVICE = "urn:xmpp:spaces:persistence";
	public String XMPP_PUBSUB = "http://jabber.org/protocol/pubsub";
	public String MODEL_CDT = "mirror:common:datatypes";
	public String XMPP_DATA = "jabber:x:data";
}
