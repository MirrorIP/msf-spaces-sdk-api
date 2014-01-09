package de.imc.mirror.sdk.cdm;

import de.imc.mirror.sdk.CDMData;

/**
 * Interface for the common data model version 1.0.
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface CDMData_1_0 extends CDMData {
	/**
	 * Returns the version of the data model the object instantiates.
	 * @return Model version string.
	 */
	public String getModelVersion();
	
	/**
	 * Returns the custom identifier of the data object.
	 * @return Custom object identifier or <code>null</code> if not set. 
	 */
	public String getCustomId();
	
	/**
	 * Returns the publisher of the data object. 
	 * This attribute is optional, but is verified by the service if set.
	 * @return Full-JID of the data object publisher. 
	 */
	public String getPublisher();
	
	/**
	 * Returns the URI the object refers to, e.g., a the id of a parent object.
	 * @return URI string if a object reference is set, otherwise <code>null</code>.
	 */
	public String getRef();	
}
