package de.imc.mirror.sdk.cdm;

/**
 * Enumeration for Common Data Model versions.
 * @author simon.schwantzer(at)im-c.de
 */
public enum CDMVersion {
	CDM_0_1("0.1"),
	CDM_0_2("0.2"),
	CDM_1_0("1.0"),
	CDM_2_0("2.0");
	
	private final String versionString;
	
	private CDMVersion(String versionString) {
		this.versionString = versionString;
	}
	
	/**
	 * Returns the correct CDM version object for the given string. 
	 * @param versionString Version in string representation, e.g., "1.0".
	 * @return CDM version object or <code>null</code> of the given string cannot be mapped.
	 */
	public static CDMVersion getVersionForString(String versionString) {
		for (CDMVersion cdmVersion : CDMVersion.values()){
			if (cdmVersion.getVersionString().equalsIgnoreCase(versionString)){
				return cdmVersion;
			}
		}
		return null;
	}
	
	/**
	 * Returns the version string for this CDM version.
	 * @return CDM version as string, e.g., "1.0".
	 */
	public String getVersionString() {
		return versionString;
	}
}
