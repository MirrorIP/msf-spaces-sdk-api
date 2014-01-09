package de.imc.mirror.sdk.filter;

import de.imc.mirror.sdk.SerializableDataObjectFilter;

/**
 * Request only data objects which refer to a specific object.
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface ReferencesFilter extends SerializableDataObjectFilter {
	/**
	 * Returns the data object identifier of the reference a valid data object must contain.
	 * @return Data object identifier.
	 */
	public String getReferenceId();
}
