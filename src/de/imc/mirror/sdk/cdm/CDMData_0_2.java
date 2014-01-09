package de.imc.mirror.sdk.cdm;

import de.imc.mirror.sdk.CDMData;

/**
 * Interface for the common data model version 0.2.
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface CDMData_0_2 extends CDMData {
	/**
	 * Returns the publisher of the data object. 
	 * This attribute is optional, but is verified by the service if set.
	 * @return Full-JID of the data object publisher. 
	 */
	public String getCreator();
	
	/**
	 * Returns the URI the object refers to, e.g., a the id of a parent object.
	 * @return URI string if a object reference is set, otherwise <code>null</code>.
	 */
	public String getRef();
}
