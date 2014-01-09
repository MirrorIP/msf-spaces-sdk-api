package de.imc.mirror.sdk;

import java.io.Serializable;

/**
 * Interface for data models.
 * A data model consists of a name space and a location of a XML schema definition.
 * The XSD specifies the data model in detail.  
 * @author simon.schwantzer(at)im-c.de
 */
public interface DataModel extends Serializable {
	/**
	 * Returns the namespace of this data model.
	 * @return Namespace URI
	 */
	public String getNamespace();
	
	/**
	 * Returns the location of the schema specifying the data model.
	 * @return URL of the related XSD file.
	 */
	public String getSchemaLocation();
}
