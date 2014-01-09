package de.imc.mirror.sdk;

import java.util.Set;

/**
 * Interface for organizational spaces.
 * @author simon.schwantzer(at)im-c.de
 */
public interface OrgaSpace extends Space {
	/**
	 * Returns the multi-user chat channel of the space.
	 * @return Channel containing the multi-user chat room address.
	 */
	public SpaceChannel getMUCChannel();
	
	/**
	 * Returns the list of data models supported by this space.
	 * @return Unmodifiable set of data model objects.
	 */
	public Set<DataModel> getSupportedDataModels();
	
}
