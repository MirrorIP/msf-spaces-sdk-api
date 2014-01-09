package de.imc.mirror.sdk.cdm;

import java.util.List;

/**
 * Model for data object references.
 * @author simon.schwantzer(at)im-c.de
 */
public interface References extends CDMElement {
	/**
	 * Returns the references for the data object.
	 * @return List of references.
	 */
	public List<? extends Reference> getReferences();
}
