package de.imc.mirror.sdk.filter;

import java.util.Date;

import de.imc.mirror.sdk.SerializableDataObjectFilter;

/**
 * Restricts the period in time the data object was published. 
 * @author simon.schwantzer(at)im-c.de
 */
public interface PeriodFilter extends SerializableDataObjectFilter {
	/**
	 * Returns the earliest point in time the data object may have been published in order to pass the filter.
	 * @return Date including time and time zone information.
	 */
	public Date getFrom();
	
	/**
	 * Returns the latest point in time the data object may have been published in order to pass the filter.
	 * @return Date including time and time zone information.
	 */
	public Date getTo();
}
