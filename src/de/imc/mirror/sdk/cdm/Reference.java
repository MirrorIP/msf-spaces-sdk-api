package de.imc.mirror.sdk.cdm;


/**
 * Model for a reference as used in the CDM 2.0+.
 * @author simon.schwantzer(at)im-c.de
 */
public interface Reference extends CDMElement {
	/**
	 * Type of an object reference.
	 */
	public enum ReferenceType {
		DEPENDENCY,
		WEAK;
		
		/**
		 * Returns the reference type for the given XML attribute value.
		 * @param valueString Value of the <code>type</code> attribute.
		 * @return Reference type or {@link ReferenceType#DEPENDENCY}, if the value string is null or cannot be mapped.
		 */
		public static ReferenceType getTypeForString(String valueString) {
			for (ReferenceType type : ReferenceType.values()) {
				if (type.toString().toLowerCase().equals(valueString)) {
					return type;
				}
			}
			return DEPENDENCY; // default value
		}
		
		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}
	
	/**
	 * Returns the data object identifier of the reference.
	 * @return Data object identifier.
	 */
	public String getId();
	
	/**
	 * Returns the type of the reference. A reference is either {@link ReferenceType#WEAK} or marked as {@link ReferenceType#DEPENDENCY}.
	 * Dependencies are taken into consideration for the data object lifetime management. Weak dependencies indicate a minor connection between two data objects.
	 * @return {@link ReferenceType#DEPENDENCY} or {@link ReferenceType#WEAK}.
	 */
	public ReferenceType getReferenceType();
}
