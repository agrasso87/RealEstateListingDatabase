package M1Homework;

/**
 * The CommercialProperty Class is a child class of the Property class
 * that can be listed in the Real Estate Listing database.
 * 
 * In addition to the instance data variables of Property, CommercialProperty
 * also has an instance data variable that describes the type of business that 
 * the Commercial Property houses.
 * 
 * @author Alex
 *
 */

public class CommercialProperty extends Property {

	private String businessType;
	
	public static final double C_MORTGAGE = .075;
	public static final double C_TAX = .021;
	public static final double C_COMMISSION = .08;
	

	public CommercialProperty(String a, int v, int ln, String b) {
		super(a, v, ln);
		businessType = b;
	}
	
	public CommercialProperty () {
		this(null, 0, 0, null);
	}
	
	public void setBusiness(String b) {
		businessType = b;
	}
	
	public String getBusiness() {
		return businessType;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\r\nThe business type is: " + businessType;
	}
	
	@Override
	public boolean equals(Object otherProperty) {
		CommercialProperty other = (CommercialProperty) otherProperty;
		if (super.equals(other) &&
			other.businessType.equals(businessType))
				return true;
			else
				return false;
	}
	
	/**
	 * This method overrides the parent mortgageCalculator() method and provides
	 * an estimated value for the monthly mortgage based on historical commercial
	 * mortgage rates
	 * 
	 * @return estimated monthly mortgage
	 */
	
	@Override
	public double mortgageCalculator() {
		return ((this.getValue() + (this.getValue() * CommercialProperty.C_MORTGAGE))/30);
	}
	
	/**
	 * This method overrides the parent taxCalculator() method and provides
	 * an estimated value for the annual property tax based on historical commercial
	 * property tax rates
	 * 
	 * @return estimated annual property tax
	 */
	
	@Override
	public double taxCalculator() {
		return (this.getValue() * CommercialProperty.C_TAX);
	}
	
	/**
	 * This method overrides the parent commissionCalculator() method and provides
	 * an estimated value for the percent commission on the 
	 * sale of the property by a broker based on the historical commercial broker commissions.
	 * 
	 * @return estimated broker's commission
	 */
	
	@Override
	public double commissionCalculator() {
		return (this.getValue() * CommercialProperty.C_COMMISSION);
	}
}
