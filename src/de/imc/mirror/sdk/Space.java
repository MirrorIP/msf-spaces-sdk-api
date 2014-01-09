package de.imc.mirror.sdk;

import java.io.Serializable;
import java.util.Set;

import javax.xml.datatype.Duration;

/**
 * Model for a MIRROR reflection space.
 * An implementation of this interface should be abstract to force typed spaces.
 * @author simon.schwantzer(at)im-c.de
 */
public interface Space extends Serializable {
	/**
	 * Enumeration for space types.
	 */
	public enum Type {
		PRIVATE,
		TEAM,
		ORGA,
		OTHER;
		
		/**
		 * Returns the type for the given string.
		 * @param valueString String representation of the space type.
		 * @return Space type represented by the string or <code>SpaceType.OTHER</code> if string doesn't match. 
		 */
		public static Type getType(String valueString) {
			for (Type type : Type.values()) {
				if (type.toString().equalsIgnoreCase(valueString)) {
					return type;
				}
			}
			return OTHER;
		}
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	/**
	 * Enumeration for space persistence types.
	 */
	public enum PersistenceType {
		/**
		 * Data objects published on the space are persisted. 
		 */
		ON,
		/**
		 * Published data objects are not persisted.
		 */
		OFF,
		/**
		 * Data objects are persisted for a specific period from their publishing time.
		 */
		DURATION;
	}
	
	/**
	 * Returns the id of this space. The space id is unique with a domain.
	 * @return Space identifier.
	 */
	public String getId();
	
	/**
	 * Returns the XMPP domain the space is located on.
	 * E.g., if the space is handled by spaces.mirror-demo.eu, the domain is "mirror-demo.eu". 
	 * @return Domain the spaces service is located, which provides the space.
	 */
	public String getDomain();
	
	/**
	 * Returns the name of the space.
	 * The name is a human-readable string meant to be displayed to the user. 
	 * @return Name of the space or <code>null</code> if no name is set.
	 */
	public String getName();
	
	/**
	 * Returns the type of this space.
	 * @return Space type.
	 */
	public Type getType();
	
	/**
	 * Returns the persistence setting of this space.
	 * @return {@link PersistenceType#OFF}, {@link PersistenceType#ON}, or {@link PersistenceType#DURATION}.
	 */
	public PersistenceType getPersistenceType();
	
	/**
	 * Returns the duration for which data objects are persisted after their publishing date.
	 * Only set if the space's persistence setting is {@link PersistenceType#DURATION}.
	 * @return XSD duration object or <code>null</code> if the persistence setting is not {@link PersistenceType#DURATION}.  
	 */
	public Duration getPersistenceDuration();
	
	/**
	 * Returns the list of members of the space.
	 * @return Unmodifiable set of space member models containing user and role information.
	 */
	public Set<SpaceMember> getMembers();
	
	/**
	 * Checks if the given user is member of this space.
	 * @param userId Bare-JID of the user to check the membership for.
	 * @return <code>true</code> if the user is member of the space, otherwise <code>false</code>.
	 */
	public boolean isMember(String userId);
	
	/**
	 * Checks if the given user is moderator of the space.
	 * @param userId Bare-JID of the user to check.
	 * @return <code>true</code> if the user is moderator of the space, otherwise <code>false</code>.
	 */
	public boolean isModerator(String userId);
	
	/**
	 * Returns the list of channels available for this space.
	 * @return Unmodifiable set of space channel objects.
	 */
	public Set<SpaceChannel> getChannels();
	
	/**
	 * Returns the publish-subscribe channel of the space.
	 * @return Publish-Subscribe channel of the space.
	 */
	public SpaceChannel getPubSubChannel();
	
	/**
	 * Returns the persistence channel of the space.
	 * @return Persistence channel if the space is configured to persist data, otherwise <code>null</code>.
	 */
	public SpaceChannel getPersistenceChannel();
	
	/**
	 * Generates a space configuration based on the configuration of this space.
	 * Changes applied to the generated configuration are not applied this space. To the change the configuration of a
	 * existing space, perform the following steps:
	 * 1. Generate a space configuration object using this method. 
	 * 2. Modify the space configuration object.
	 * 3. Use <code>SpaceHandler.configureSpace()</code> to apply the configuration.
	 * @return Space configuration with the settings of this space.
	 */
	public SpaceConfiguration generateSpaceConfiguration();
}
