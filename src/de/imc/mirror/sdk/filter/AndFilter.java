package de.imc.mirror.sdk.filter;

import java.util.Set;

import de.imc.mirror.sdk.DataObjectFilter;

/**
 * This meta filter represents a logical AND. IF and only if any child filter validates the data object,
 * this filter will validate it too.
 * 
 * @author simon.schwantzer(at)im-c.de
 */
public interface AndFilter extends DataObjectFilter {
	/**
	 * Adds a child filter.
	 * @param filter Filter to add.
	 * @return This meta filter.
	 */
	public DataObjectFilter addFilter(DataObjectFilter filter);
	
	/**
	 * Returns the immutable set of child filters.
	 * @return Set of filters aggregated in this meta filter.
	 */
	public Set<DataObjectFilter> getFilters();
}
