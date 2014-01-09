package de.imc.mirror.sdk.cdm;

import java.util.Date;

/**
 * Model for the creation information as available with CDM 2.0. 
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface CreationInfo extends CDMElement {
	/**
	 * Returns the date when the data object was created.
	 * @return Data of creation.
	 */
	public Date getCreationDate();

	/**
	 * Returns the creator of the data object.
	 * @return Identifier, e.g. bare-JID, for the creator. May be <code>null</code> if no creator is set.
	 */
	public String getCreator();
	
	/**
	 * Return the application which created the data object. 
	 * @return Identifier (e.g. namespace) of the application in which the data object was created. May be <code>null</code> if this information is not available.
	 */
	public String getApplication();
}
