package de.imc.mirror.sdk;

import java.io.Serializable;

/**
 * Interface for space member models.
 * @author simon.schwantzer(at)im-c.de
 */
public interface SpaceMember extends Serializable {
	public enum Role {
		MEMBER,
		MODERATOR;
	}
	
	/**
	 * Returns the user JID of the member.
	 * @return Bare-JID of the member.
	 */
	public String getJID();
	
	/**
	 * Returns the role of the member.
	 * @return <code>SpaceMember.Role.MODERATOR</code> if the member is also moderator of the space, otherwise <code>SpaceMember.Role.MEMBER</code>.
	 */
	public Role getRole();
}
