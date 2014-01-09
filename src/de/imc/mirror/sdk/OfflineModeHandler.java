package de.imc.mirror.sdk;

/**
 * Interface for handler supporting offline mode switching, i.e., allow operations to
 * be performed offline.
 * @author simon.schwantzer(at)im-c.de
 */
public interface OfflineModeHandler {
	public enum Mode {
		ONLINE,
		OFFLINE
	}
	
	/**
	 * Sets the mode for the handler.
	 * @param mode Mode to set. 
	 */
	public void setMode(Mode mode);
	
	/**
	 * Returns the current mode of the handler.
	 * @return Mode.ONLINE or Mode.OFFLINE.
	 */
	public Mode getMode();
	
	/**
	 * Deletes locally stored data.
	 */
	public void clear();
}
