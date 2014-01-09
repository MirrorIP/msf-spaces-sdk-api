package de.imc.mirror.sdk;

import java.util.Set;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import de.imc.mirror.sdk.Space.PersistenceType;

/**
 * A container for space configuration 
 * @author simon.schwantzer(at)im-c.de
 */
public interface SpaceConfiguration {
	
	/**
	 * Sets the type for the space.
	 * @param type Space type.
	 */
	public void setType(Space.Type type);
	
	/**
	 * Returns the space type.
	 * @return Space type.
	 */
	public Space.Type getType();
	
	/**
	 * Sets the name of the space.
	 * @param name Human-readable name for the space.
	 */
	public void setName(String name);
	
	/**
	 * Returns the name set for the space.
	 * @return Human-readable name for the space.
	 */
	public String getName();
	
	/**
	 * Sets the persistence type of the space.
	 * A space can be configured to either do not persist published data objects ({@link PersistenceType#OFF}),
	 * persist data objects ({@link PersistenceType#ON}), or persist data object for a specific duration 
	 * ({@link PersistenceType#DURATION}).
	 * @param persistenceType Persistence type to set.
	 */
	public void setPersistenceType(PersistenceType persistenceType);
	
	/**
	 * Returns the persistence configuration of the space.
	 * @return Either {@link PersistenceType#OFF}, {@link PersistenceType#ON}, or {@link PersistenceType#DURATION}.
	 */
	public PersistenceType getPersistenceType();
	
	/**
	 * Sets the duration for the data object persistence.
	 * Only required when the persistence type is {@link PersistenceType#DURATION}.
	 * @param duration Duration to set. See {@link DatatypeFactory} for details about instantiating a duration. 
	 */
	public void setPersistenceDuration(Duration duration);
	
	/**
	 * Returns the duration for the data object persistence.
	 * Only set when the persistence type is {@link PersistenceType#DURATION}.
	 * @return Duration or <code>null</code>, if the space's persistence type is not {@link PersistenceType#DURATION}.
	 */
	public Duration getPersistenceDuration(); 
	
	/**
	 * Returns the space members.
	 * Member role are assigned in the space member models.
	 * @return Set of space members.
	 */
	public Set<SpaceMember> getMembers();
	
	/**
	 * Sets the members for the space.
	 * Member role are assigned in the space member models.
	 * @param members Set of space members to set.
	 */
	public void setMembers(Set<SpaceMember> members);
	
	/**
	 * Adds a member to the space.
	 * If a given user is already member of the space, only the role will be updated.
	 * @param member Space member model to set.
	 */
	public void addMember(SpaceMember member);
	
	/**
	 * Revokes membership of a user.
	 * If the user is not stored in the list of members, nothing will happen. 
	 * @param userId Bare-JID of the user to revoke membership. 
	 */
	public boolean removeMember(String userId);

}
