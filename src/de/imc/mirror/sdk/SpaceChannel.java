package de.imc.mirror.sdk;

import java.io.Serializable;
import java.util.Map;

/**
 * Interface for space channel implementations.
 * @author simon.schwantzer(at)im-c.de
 */
public interface SpaceChannel extends Serializable {
	
	/**
	 * Returns the channel type.
	 * @return Type of the channel.
	 */
	public String getType();
	
	/**
	 * Returns a map of channel properties.
	 * The availability of properties depends on the channel type. 
	 * @return Unmodifiable map of channel properties, i.e., key-value pairs.
	 */
	public Map<String, String> getProperties();
}
