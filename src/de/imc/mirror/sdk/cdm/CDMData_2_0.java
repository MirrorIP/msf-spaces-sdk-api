package de.imc.mirror.sdk.cdm;

import de.imc.mirror.sdk.CDMData;

/**
 * Interface for the common data model version 1.0.
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface CDMData_2_0 extends CDMData {
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
	
	/**
	 * Checks if this data object updates another data object. 
	 * @return <code>true</code> if the data object contains an <code>updated</code> attribute, otherwise <code>false</code>.
	 */
	public boolean isUpdate();
	
	/**
	 * Return the identifier of the data object updated by this object, or <code>null</code> if this is no update to another data object.
	 * @return Data object identifier.
	 */
	public String getUpdatedObjectId();
	
	/**
	 * Checks if this data objects is a copy of another data object.
	 * @return <code>true</code> if the data object contains an <code>copyOf</code> attribute, otherwise <code>false</code>.
	 */
	public boolean isCopy();
	
	/**
	 * Returns the identifier of the data object copied by this object, or <code>null</code> if this is no copy.
	 * @return Data object identifier.
	 */
	public String getCopyOf();
	
	/**
	 * Returns the summary, i.e. textual description, for this data object.
	 * @return Summary of the data objects content, or <code>null</code> if not set.
	 */
	public Summary getSummary();
	
	/**
	 * Return the list of references to other data objects.
	 * @return References model.
	 */
	public References getReferences();
	
	/**
	 * Returns the creation information of this data object.
	 * @return Creation information or <code>null</code> if no creation information is available.
	 */
	public CreationInfo getCreationInfo();
}
