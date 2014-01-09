package de.imc.mirror.sdk;

/**
 * Interface for listeners of data objects exchanged over MIRROR spaces.
 * @author simon.schwantzer(at)im-c.de
 */
public interface DataObjectListener {
	
	/**
	 * Called when a data object is received over the pubsub node from a MIRROR space.
	 * @param dataObject Data object received.
	 * @param spaceId Identifier of the space the data object was published on.
	 */
	public void handleDataObject(DataObject dataObject, String spaceId);
}
