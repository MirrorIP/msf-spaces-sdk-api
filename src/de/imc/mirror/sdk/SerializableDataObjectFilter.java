package de.imc.mirror.sdk;

import org.jdom2.Element;

/**
 * Interface for data object filters which can be serialized and used in file service queries.
 * @author simon.schwantzer(at)im-c.de
 */
public interface SerializableDataObjectFilter extends DataObjectFilter {
	/**
	 * Returns the filter represented as XML element to be used in a query.
	 * @param queryNamespace Namespace URI the element should implement.
	 * @return XML element to be added to an query.
	 */
	public Element getFilterAsXML(String queryNamespace);

}
