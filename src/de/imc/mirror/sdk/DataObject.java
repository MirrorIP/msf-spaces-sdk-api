package de.imc.mirror.sdk;

import java.io.Serializable;

import org.jdom2.Element;

/**
 * Interface for MIRROR data objects.
 * A data object represents an item published on a pubsub node of a space.
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface DataObject extends Serializable {
	/**
	 * Returns the namespace URI of the data object.
	 * @return Namespace URI string.
	 */
	public String getNamespaceURI();
	
	/**
	 * Returns the data model for the data object.
	 * The returned model is not necessarily a MIRROR data model. No object verification is applied.
	 * @return Model the data object claims to instantiate.
	 */
	public DataModel getDataModel();
	
	/**
	 * Returns the XML element for this data object.
	 * @return XML element. This is the payload published on the pubsub node.
	 */
	public Element getElement();
	
	/**
	 * Checks if the data object claims to be an instance of a MIRROR data model.
	 * A simple namespace comparison is applied, but no verification.
	 * @return <code>true</code> if the XML object is from the MIRROR application namespace, otherwise <code>false</code>.
	 */
	public boolean isMIRRORDataObject();
	
	/**
	 * Returns the common data model information for this object.
	 * If no information is contained, i.e., the data object does not instantiate a
	 * MIRROR data model, <code>null</code> will be returned.
	 * @return CDM information container or <code>null</code> if no CDM data is available.
	 */
	public CDMData getCDMData();
	
	/**
	 * Returns the unique identifier of this data object provided by the CDM.
	 * Refers to DataObject.getCDMData().getId();
	 * @see CDMData#getId()
	 * @return Data object identifier.
	 */
	public String getId();
	
}
