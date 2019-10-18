/**
 * The Property Class is the parent class to all the sub-types of Real Property
 * that can be listed in the Real Estate Listing database.
 * 
 * The Class has the following instance data variables that describe the property:
 * address which gives the location of the property, value which describes how much the 
 * property is worth and listingNumber which holds the listing number that identifies the 
 * property's MLS listing.
 * 
 * 10.18.19
 * Added static variable to Property class that keeps a count of properties created, incremented
 * each time that a new Property object is created.
 * Added an enum class to describe the sale status of the property, initialized as AVALIABLE
 * Implemented a compareTo method for ordering of properties	  
 * 
 * @author Alex
 *
 */

public class Property implements Comparable<Property> {
	
	private String address;
	private int value;
	private int listingNumber;
	
	public static final double AVERAGE_TAX = .04;
	public static final double AVERAGE_MORTGAGE = .047;
	public static final double AVERAGE_COMMISSION = .0508;
	
	//static variable
	private static int totalProperties = 0;
	
	//Enum variable
	private Sale saleStatus;
	
	/**
	 * default constructor and three-variable constructor included, must have all three
	 * instance fields in order to create the Property object.
	 */
	
	public Property() {
		this(null, 0, 0);
	}
	
	public Property(String a, int v, int ln) {
		address = a;
		value = v;
		listingNumber = ln;
		Property.totalProperties++;
		saleStatus = Sale.AVAILABLE;
	}
	
	public void setAddress(String s) {
		address = s;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setValue(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setListingNumber(int ln) {
		listingNumber = ln;
	}
	
	public int getListingNumber() {
		return listingNumber;
	}
	
	//Enum setter
	public void setSaleStatus(Sale s) {
		saleStatus = s;
	}
	
	//Enum getter
	public Sale getSaleStatus() {
		return saleStatus;
	}
	
	public String toString() {
		return "The property is located at: " + address +"\r\n"
				+ "The value of the property is: $" + value + "\r\n"
				+ "The listing number is: " + listingNumber + "\r\n"
				+ "Sale Status: " + saleStatus.getSaleCode();
	}
	
	@Override
	public boolean equals(Object otherProperty) {
		if (otherProperty instanceof Property) {
			Property other = (Property) otherProperty;
			return (other.address.equals(address) &&
					other.value == value &&
					other.listingNumber == listingNumber);
		} else
				return false;
	}
	
	/**
	 * This calculator method is used to return the estimated monthly mortgage based on
	 * the property value.
	 * @return estimated monthly mortgage
	 */
	
	public double mortgageCalculator() {
		return ((value + (value * Property.AVERAGE_MORTGAGE))/30);
	}
	
	/**
	 * This calculator method is used to return the estimated annual property tax that 
	 * will be assessed against the property based on its value.
	 * @return estimated annual property tax
	 */
	
	public double taxCalculator() {
		return (value * Property.AVERAGE_TAX);
	}
	
	/**
	 * This calculator method is used to return the estimated percent commission on the 
	 * sale of the property by a broker based on the property's value.
	 * @return estimated broker's commission
	 */
	
	public double commissionCalculator() {
		return (value * Property.AVERAGE_COMMISSION);
	}
	
	//static method for getting total number of Properties
	public static int getTotalProperties() {
		return Property.totalProperties;
	}
	
	//static method for removing a Property from the total count
	public static void removeProperty() {
		Property.totalProperties--;
	}
	
	//compareTo method
	public int compareTo(Property p) {
		if(this.value > p.value) { //the property is greater than because it is worth more
			return 1;
		} else if(this.value < p.value) { //the property is less than because it is worth less
			return -1;
		} else { //the values are equal - check the listing number
			if(this.listingNumber > p.listingNumber)
				return 1; //the property is greater than because it is a newer listing
			else if(this.listingNumber < p.listingNumber)
				return -1; //the property is less than because it is an older listing
			else
				return 0; //the property is the same because it has the same listing number
		}
	}
}
