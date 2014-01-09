package de.imc.mirror.sdk.filter;

import de.imc.mirror.sdk.SerializableDataObjectFilter;

/**
 * Filter for specific namespaces.
 * Restricts the query to specific namespaces, e.g. "mirror:application:moodmap:mood".
 * @author simon.schwantzer(at)im-c.de
 */
public interface NamespaceFilter extends SerializableDataObjectFilter {
	/**
	 * Compare type for the namespace filter.
	 * @author simon.schwantzer(at)im-c.de
	 *
	 */
	public enum CompareType {
		/**
		 * The namespace has to be equal the given compare string.
		 */
		STRICT,
		/**
		 * The namespace must contain the given compare string.
		 */
		CONTAINS,
		/**
		 * The namespace must match the regex given with the compare string.
		 */
		REGEX;
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	/**
	 * Returns the string to compare the namespace URI against.
	 * @return String for comparison.
	 */
	public String getCompareString();
	
	/**
	 * Returns the type of the comparison.
	 * @return Compare type.
	 */
	public CompareType getCompareType();
}
