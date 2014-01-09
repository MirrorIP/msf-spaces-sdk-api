package de.imc.mirror.sdk.filter;

import de.imc.mirror.sdk.SerializableDataObjectFilter;

/**
 * Filter for data model information.
 * @author simon.schwantzer(at)im-c.de
 */
public interface DataModelFilter extends SerializableDataObjectFilter {
	/**
	 * Returns the namespace of the data model to filter for.
	 * @return Namespace URI as string.
	 */
	public String getNamespace();
	
	/**
	 * Returns the data model version to filter for.
	 * @return Version string or <code>null</code> if the filter accepts all versions of the data model.
	 */
	public String getVersion();
}
