package M1Homework;

/**
 * The IndustrialProperty Class is a child class of the Property class
 * that can be listed in the Real Estate Listing database.
 * 
 * In addition to the instance data variables of Property, IndustrialProperty
 * also has an instance data variable that describes the manufacturing type that 
 * the Industrial Property houses.
 * 
 * @author Alex
 *
 */

public class IndustrialProperty extends Property {

	private String manufactType;
	
	public static final double I_MORTGAGE = .0525;
	public static final double I_TAX = .016;
	public static final double I_COMMISSION = .04;
	

	public IndustrialProperty(String a, int v, int ln, String m) {
		super(a, v, ln);
		manufactType = m;
	}
	
	public IndustrialProperty () {
		this(null, 0, 0, null);
	}
	
	public void setManufacturing(String b) {
		manufactType = b;
	}
	
	public String getManufacturing() {
		return manufactType;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\r\nThe manufacturing type is: " + manufactType;
	}
	
	@Override
	public boolean equals(Object otherProperty) {
		IndustrialProperty other = (IndustrialProperty) otherProperty;
		if (this.equals(other) &&
			other.manufactType.equals(manufactType))
				return true;
			else
				return false;
	}
	
	/**
	 * This method overrides the parent mortgageCalculator() method and provides
	 * an estimated value for the monthly mortgage based on historical industrial
	 * mortgage rates
	 * 
	 * @return estimated monthly mortgage
	 */
	@Override
	public double mortgageCalculator() {
		return ((this.getValue() + (this.getValue() * IndustrialProperty.I_MORTGAGE))/30);
	}
	
	/**
	 * This method overrides the parent taxCalculator() method and provides
	 * an estimated value for the annual property tax based on historical industrial
	 * property tax rates
	 * 
	 * @return estimated annual property tax
	 */
	@Override
	public double taxCalculator() {
		return (this.getValue() * IndustrialProperty.I_TAX);
	}
	
	/**
	 * This method overrides the parent commissionCalculator() method and provides
	 * an estimated value for the percent commission on the 
	 * sale of the property by a broker based on the historical industrial broker commissions.
	 * 
	 * @return estimated broker's commission
	 */
	@Override
	public double commissionCalculator() {
		return (this.getValue() * IndustrialProperty.I_COMMISSION);
	}
}
