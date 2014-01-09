package de.imc.mirror.sdk.filter;

import de.imc.mirror.sdk.SerializableDataObjectFilter;

/**
 * Only data objects from the given publisher (bare-JID or full-JID) are returned. Removes all non-personalized data objects.
 * @author simon.schwantzer(at)im-c.de
 *
 */
public interface PublisherFilter extends SerializableDataObjectFilter {
	/**
	 * Returns the JID of the publisher filtered by this filter.
	 * @return Either bare-JID or full-JID as string.
	 */
	public String getPublisher();
}
