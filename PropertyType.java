
public enum PropertyType {
	RESIDENTIAL("R"), COMMERCIAL("C"), INDUSTRIAL("I"), UNASSIGNED("U");
	
	private String propertyCode;
	
	private PropertyType(String code) {
		this.propertyCode = code;
	}
	
	public String getPropertyCode() {
		return this.propertyCode;
	}
}
