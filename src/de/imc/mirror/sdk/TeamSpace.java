package de.imc.mirror.sdk;

/**
 * Interface for team spaces.
 * @author simon.schwantzer(at)im-c.de
 */
public interface TeamSpace extends Space {
	/**
	 * Returns the multi-user chat channel of the space.
	 * @return Channel containing the multi-user chat room address.
	 */
	public SpaceChannel getMUCChannel();
	
}
