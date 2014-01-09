package de.imc.mirror.sdk.cdm;

import de.imc.mirror.sdk.CDMData;

/**
 * Interface for the common data model version 0.1.
 * @author simon.schwantzer(at)im-c.de
 */
public interface CDMData_0_1 extends CDMData {
	/**
	 * Returns the creator of the data object.
	 * @return Full JID of the creator of the data object. May be <code>null</code>.
	 */
	public String getCreator();
}
