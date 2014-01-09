package de.imc.mirror.sdk;

/**
 * Configuration for the XMPP connection.
 * @author simon.schwantzer(at)im-c.de
 */
public interface ConnectionConfiguration {

	/**
	 * Returns the XMPP domain.
	 * In most cases, the XMPP domain equals the DNS domain.
	 * @return Domain domain name.
	 */
	public String getDomain();
	
	/**
	 * Returns the configured host name of IPv4 address.
	 * By default, the hostname equals the XMPP domain name. 
	 * @return Hostname or IPv4 address.
	 */
	public String getHost();
	
	/**
	 * Returns the XMPP server port.
	 * Defaults to the standard port 5222.
	 * @return Server port.
	 */
	public int getPort();
	
	/**
	 * Returns the application identifier.
	 * The identifier is an arbitrary string, which should be unique for the application.
	 * @return Application identifier.
	 */
	public String getApplicationID();
	
	/**
	 * Checks if the connection is configured to be secure.
	 * Defaults to <code>true</code>. 
	 * @return <code>true</code> if the connection is configured to be TLS encrypted, otherwise <code>false</code>.
	 */
	public boolean isSecureConnection();
	
	/**
	 * Checks if the connection accepts self-signed certificates.
	 * Defaults to <code>true</code>. 
	 * @return <code>true</code> if self-signed certificates are accepted, otherwise <code>false</code>.
	 */
	public boolean isSelfSignedCertificateEnabled();
	
	/**
	 * Returns the duration until a request times out.
	 * Defaults to 2000 ms.
	 * @return Timeout in milliseconds.
	 */
	public int requestTimeout();
}
