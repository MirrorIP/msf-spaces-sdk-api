package de.imc.mirror.sdk;

import java.io.Serializable;
import java.util.Date;

import de.imc.mirror.sdk.cdm.CDMVersion;

/**
 * Interface for data part of common data model. 
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface CDMData extends Serializable {
	/**
	 * Returns the version information of common data model implemented.
	 * The CDM version information is only available in all objects with support for CDM version 1.0 or higher.  
	 * @return Version information if a CDM version is set, otherwise <code>null</code>.
	 */
	public CDMVersion getCDMVersion();
	
	/**
	 * Returns the ID of the data object.
	 * The ID is unique within the domain and set by the server.
	 * @return Data object identifier.
	 */
	public String getId();
	
	/**
	 * Returns the time the object was published.
	 * The point in time is determined by the server.
	 * @return Point in time the data object was published.
	 */
	public Date getTimeStamp();
}
