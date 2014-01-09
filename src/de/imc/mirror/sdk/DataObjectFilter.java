package de.imc.mirror.sdk;


/**
 * Interface for data object filters.
 * @author simon.schwantzer(at)im-c.de
 */
public interface DataObjectFilter {	
	/**
	 * Checks if a data object is valid, i.e. passes the filter.
	 * @param dataObject Data object to validate.
	 * @return <code>true</code> if the data object applies to the conditions of the filter, otherwise <code>false</code>.
	 */
	public boolean isDataObjectValid(DataObject dataObject);
}
