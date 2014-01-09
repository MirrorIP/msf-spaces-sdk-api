package de.imc.mirror.sdk;

import java.util.List;
import java.util.Map;
import java.util.Set;

import de.imc.mirror.sdk.exceptions.ConnectionStatusException;
import de.imc.mirror.sdk.exceptions.SpaceManagementException;

/**
 * Handler for operations related to MIRROR spaces.
 * @author simon.schwantzer(at)im-c.de
 */
public interface SpaceHandler extends OfflineModeHandler {
	public String SERVICE_PREFIX = "spaces.";
	
	/**
	 * Returns a specific space.
	 * ONLINE mode: The information is retrieved from the server, the local cache is updated, and the information is returned.
	 * OFFLINE mode: The the information from the local cache is returned if available.
	 * @param spaceId Identifier of the space to retrieve.
	 * @return Space with the given id or <code>null</code> if no space with such an id is available for the user.
	 */
	public Space getSpace(String spaceId);
	
	/**
	 * Returns a list of all spaces available to the user.
	 * ONLINE mode: The information is retrieved from the server, the local cache is updated, and the information is returned.
	 * OFFLINE mode: The the information available in the local cache is returned.
	 * @return Unmodifiable list containing all spaces available to the user. May be empty.
	 */
	public List<Space> getAllSpaces();
	
	/**
	 * Returns a map containing the space identifiers and names for all spaces available to the user.
	 * ONLINE mode: The information is retrieved from the server and the information is returned.
	 * OFFLINE mode: The the information available in the local cache is returned.
	 * Requesting the list without spaces details is faster and should be preferred to <code>SpacesManager.getAllSpaces()</code> whenever possible.
	 * @return Unmodifiable map of space identifiers and related space names.
	 */
	public Map<String, String> getSpacesList();
	
	/**
	 * Creates a private space for the current user.
	 * @return Return The private space created for the current user.
	 * @throws SpaceManagementException Failed to create default space. 
	 * @throws ConnectionStatusException The handler needs to be ONLINE to perform this operation.
	 */
	public PrivateSpace createDefaultSpace() throws SpaceManagementException, ConnectionStatusException;
	
	/**
	 * Returns the private space of the user. 
	 * ONLINE mode: The information is retrieved from the server, the local cache is updated, and the information is returned.
	 * OFFLINE mode: The the information available in the local cache is returned.
	 * @return Private space of the user or <code>null</code> if no private space is set up.
	 */
	public PrivateSpace getDefaultSpace();
	
	/**
	 * Creates a space with the given configuration.
	 * @param spaceConfig Space configuration to apply.
	 * @return Space created.
	 * @throws SpaceManagementException Failed to create the space. 
	 * @throws ConnectionStatusException The handler needs to be ONLINE to perform this operation.
	 */
	public Space createSpace(SpaceConfiguration spaceConfig) throws SpaceManagementException, ConnectionStatusException;
	
	/**
	 * Tries to apply a configuration to a space.
	 * @param spaceId Identifier of the space to apply configuration on. 
	 * @param spaceConfig Space configuration to apply.
	 * @return Space after the configuration was successfully applied.
	 * @throws SpaceManagementException Failed to apply space configuration.
	 * @throws ConnectionStatusException The handler needs to be ONLINE to perform this operation.
	 */
	public Space configureSpace(String spaceId, SpaceConfiguration spaceConfig) throws SpaceManagementException, ConnectionStatusException;
	
	/**
	 * Deletes the space with the given id.
	 * @param spaceId Identifier of the space to delete.
	 * @throws SpaceManagementException Failed to delete the space.
	 * @throws ConnectionStatusException The handler needs to be ONLINE to perform this operation.
	 */
	public void deleteSpace(String spaceId) throws SpaceManagementException, ConnectionStatusException;
	
	/**
	 * Sets the data models supported by an organizational space.
	 * Performing this operation on spaces of types other than Space.Type.ORGA will fail.
	 * Only data objects instantiating one of the supported data models may be published on this space. 
	 * @param spaceId Identifier of the organizational space to set list of supported models for.
	 * @param dataModels Set of data models to support.
	 * @return Space after the setting has been successfully applied.
	 * @throws SpaceManagementException Failed to apply setting, e.g., because the space is not of type Space.Type.ORGA.
	 * @throws ConnectionStatusException The handler needs to be ONLINE to perform this operation.
	 */
	public OrgaSpace setModelsSupportedBySpace(String spaceId, Set<DataModel> dataModels) throws SpaceManagementException, ConnectionStatusException; 
}
