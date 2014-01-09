package de.imc.mirror.sdk;

/**
 * Interface for private spaces.
 * @author simon.schwantzer(at)im-c.de
 */
public interface PrivateSpace extends Space {
	/**
	 * Returns the owner of the private space.
	 * @return Bare-JID of the owner of this space.
	 */
	public String getOwner();
}
