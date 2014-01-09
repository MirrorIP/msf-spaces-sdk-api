package de.imc.mirror.sdk.cdm;

/**
 * Model for a summary as used in CDM 2.0.
 * A summary is a textual description of the content of a data object. 
 * @author simon.schwantzer(at)im-c.de
 */
public interface Summary extends CDMElement {
	/**
	 * Return the summary. 
	 * @return Textual summary.
	 */
	public String getSummary();
}
