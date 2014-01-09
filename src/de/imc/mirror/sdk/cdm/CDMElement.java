package de.imc.mirror.sdk.cdm;

import org.jdom2.Element;

/**
 * Interface for CDM element structures.
 * @author simon.schwantzer(at)im-c.de
 */
public interface CDMElement {
	/**
	 * Generates an XML element object for this element.
	 * @param namespaceURI Namespace to be used in the element.
	 * @return XML element representing the cdm element.
	 */
	public Element generateXMLElement(String namespaceURI);
}
