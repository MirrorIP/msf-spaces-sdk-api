package de.imc.mirror.sdk;

import java.util.List;
import java.util.Set;

import de.imc.mirror.sdk.exceptions.QueryException;
import de.imc.mirror.sdk.exceptions.ConnectionStatusException;
import de.imc.mirror.sdk.exceptions.UnknownEntityException;

/**
 * Handler for the data exchange over MIRROR spaces.
 * One data handler may observe several spaces, with the restriction to one domain.
 * @author simon.schwantzer(at)im-c.de
 */
public interface DataHandler extends OfflineModeHandler {
	/**
	 * Returns the list of spaces handled by this handler.
	 * @return Unmodifiable list of spaces. May be empty.
	 */
	public List<Space> getHandledSpaces();
	
	/**
	 * Adds a space to be observed by this data handler.
	 * If the space is already in the list of observed spaces, nothing happens.
	 * @param spaceId Identifier of the space to observe.
	 * @throws UnknownEntityException Failed to register to the pubsub node of the space.
	 */
	public void registerSpace(String spaceId) throws UnknownEntityException;
	
	/**
	 * Removes a space from the list of observed spaces.
	 * If the space is not in the list of observed spaces, nothing happens.
	 * @param spaceId Identifier of the space to observe.
	 */
	public void removeSpace(String spaceId);

	/**
	 * Returns the data object filter applied to this data handler.
	 * @return Data object filter or <code>null</code> of no data object filter is set.
	 */
	public DataObjectFilter getDataObjectFilter();
	
	/**
	 * Sets an data object filter to be applied for incoming data objects.
	 * @param filter Data object filter to set.
	 */
	public void setDataObjectFilter(DataObjectFilter filter);
	
	/**
	 * Adds a listener for data objects published on any space handled by this handler.
	 * @param listener Listener to add.
	 * The call-back method of listener is called each time a new item is published on the pubsub node of a MIRROR space.   
	 */
	public void addDataObjectListener(DataObjectListener listener);
	
	/**
	 * Removes a data object listener.
	 * @param listener Listener to remove.
	 */
	public void removeDataObjectListener(DataObjectListener listener);
	
	/**
	 * Returns a unmodifiable list of data objects previously published on the space.
	 * The data objects are retrieved from the local cache and contain the latest items published.
	 * The amount of objects cache depend on the handler implementation.
	 * @param spaceId Identifier of the space to retrieve data objects for.
	 * @return List of data objects, in reverse order of their publishing time, i.e., the latest first. May be empty.
	 * @throws UnknownEntityException A space with the given id is not known to the space handler.
	 */
	public List<DataObject> retrieveDataObjects(String spaceId) throws UnknownEntityException;
	
	
	/**
	 * Queries a data object by its identifier.
	 * @param objectId Identifier for the data object to query.
	 * @return The data object with the given identifier or <code>null</code> if no such data object exists.
	 * @throws ConnectionStatusException The connection must be established in order to perform queries.
	 * @throws UnsupportedOperationException No persistence service is available to handle the request.
	 * @throws QueryException The query failed caused by the reason indicated by the exception type (see {@link QueryException#getType()}.
	 */
	public DataObject queryDataObjectById(String objectId) throws ConnectionStatusException, UnsupportedOperationException, QueryException;
	
	/**
	 * Queries multiple data objects by their identifier.
	 * @param objectIds A set of data object identifiers. 
	 * @param filters A set of filters to apply. May be empty.
	 * @return A list of data objects with the given identifiers which pass the filters. The list may be empty.
	 * @throws ConnectionStatusException The connection must be established in order to perform queries.
	 * @throws UnsupportedOperationException No persistence service is available to handle the request.
	 * @throws QueryException The query failed caused by the reason indicated by the exception type (see {@link QueryException#getType()}.
	 */
	public List<DataObject> queryDataObjectsById(Set<String> objectIds, Set<SerializableDataObjectFilter> filters) throws ConnectionStatusException, UnsupportedOperationException, QueryException;
	
	/**
	 * Queries all data objects of a single space which fits the given filters.
	 * @param spaceId Identifier of the space to request data objects from.
	 * @param filters A set of filters to apply. May be empty.
	 * @return A list of all data objects of the space which pass the filters. The list may be empty.
	 * @throws ConnectionStatusException The connection must be established in order to perform queries.
	 * @throws UnsupportedOperationException No persistence service is available to handle the request.
	 * @throws QueryException The query failed caused by the reason indicated by the exception type (see {@link QueryException#getType()}.
	 */
	public List<DataObject> queryDataObjectsBySpace(String spaceId, Set<SerializableDataObjectFilter> filters) throws ConnectionStatusException, UnsupportedOperationException, QueryException;
	
	/**
	 * Queries all data objects from multiple spaces which fits the given filters.
	 * @param spaceIds Set of identifiers for the spaces to request the data objects from.
	 * @param filters A set of filters to apply. May be empty.
	 * @return A list of all data objects which pass the filters. The list may be empty.
	 * @throws ConnectionStatusException The connection must be established in order to perform queries.
	 * @throws UnsupportedOperationException No persistence service is available to handle the request.
	 * @throws QueryException The query failed caused by the reason indicated by the exception type (see {@link QueryException#getType()}.
	 */
	public List<DataObject> queryDataObjectsBySpaces(Set<String> spaceIds, Set<SerializableDataObjectFilter> filters) throws ConnectionStatusException, UnsupportedOperationException, QueryException;
	
	/**
	 * Deletes a single data object from the storage. Only space moderators are allowed to perform this operation.
	 * @param objectId Identifier of the data object to delete.
	 * @return <code>true</code> if the data object was found and deleted, otherwise <code>false</code>.
	 * @throws ConnectionStatusException The connection must be established in order to send delete requests.
	 * @throws UnsupportedOperationException No persistence service is available to handle the request.
	 * @throws QueryException The deletion failed caused by the reason indicated by the exception type (see {@link QueryException#getType()}.
	 */
	public boolean deleteDataObject(String objectId) throws ConnectionStatusException, UnsupportedOperationException, QueryException;
	
	/**
	 * Deletes multiple data objects from the storage. Only space moderators are allowed to perform this operation.
	 * @param objectIds Set of identifiers for the data objects to delete.
	 * @return Number of deleted data objects.
	 * @throws ConnectionStatusException The connection must be established in order to send delete requests.
	 * @throws UnsupportedOperationException No persistence service is available to handle the request.
	 * @throws QueryException The deletion failed caused by the reason indicated by the exception type (see {@link QueryException#getType()}.
	 */
	public int deleteDataObjects(Set<String> objectIds) throws ConnectionStatusException, UnsupportedOperationException, QueryException;
	
	/**
	 * Publishes a data object on the space with the given id.
	 * ONLINE mode: The object is directly published on the related pubsub node.
	 * OFFLINE mode: The object is stored locally and published when the connection is establised again.
	 * @param dataObject Data object to publish.
	 * @param spaceId Identifier if the space to publish.
	 * @throws UnknownEntityException A space with the given id is not known to the space handler.
	 */
	public void publishDataObject(DataObject dataObject, String spaceId) throws UnknownEntityException;
}
