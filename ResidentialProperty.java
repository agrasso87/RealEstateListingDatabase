package M1Homework;

/**
 * The ResidentialProperty Class is a child class of the Property class
 * that can be listed in the Real Estate Listing database.
 * 
 * In addition to the instance data variables of Property, ResidentialProperty
 * also has an instance data variable that describes the number of bedrooms in the 
 * Residential Property (this is unique to Residential Properties only)
 * 
 * @author Alex
 *
 */

public class ResidentialProperty extends Property {
	
	private int bedrooms;
	
	public static final double R_MORTGAGE = .0379;
	public static final double R_TAX = .016;
	public static final double R_COMMISSION = .06;
	

	public ResidentialProperty(String a, int v, int ln, int br) {
		super(a, v, ln);
		bedrooms = br;
	}
	
	public ResidentialProperty() {
		this(null, 0, 0, 0);
	}
	
	public void setBedrooms(int b) {
		bedrooms = b;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "\r\nThe number of bedrooms is: " + bedrooms);
	}
	
	@Override
	public boolean equals(Object otherProperty) {
		ResidentialProperty other = (ResidentialProperty) otherProperty;
		if (!super.equals(other))			
				return false;
		return(other.bedrooms==bedrooms);
	}
	
	/**
	 * This method overrides the parent mortgageCalculator() method and provides
	 * an estimated value for the monthly mortgage based on historical residential
	 * mortgage rates
	 * 
	 * @return estimated monthly mortgage
	 */
	
	@Override
	public double mortgageCalculator() {
		return ((this.getValue() + (this.getValue() * ResidentialProperty.R_MORTGAGE))/30);
	}
	
	/**
	 * This method overrides the parent taxCalculator() method and provides
	 * an estimated value for the annual property tax based on historical residential
	 * property tax rates
	 * 
	 * @return estimated annual property tax
	 */
	
	@Override
	public double taxCalculator() {
		return (this.getValue() * ResidentialProperty.R_TAX);
	}
	
	/**
	 * This method overrides the parent commissionCalculator() method and provides
	 * an estimated value for the percent commission on the 
	 * sale of the property by a broker based on the historical residential broker commissions.
	 * 
	 * @return estimated broker's commission
	 */
	
	@Override
	public double commissionCalculator() {
		return (this.getValue() * ResidentialProperty.R_COMMISSION);
	}
}
