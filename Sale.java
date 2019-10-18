/**
 * enum class that describes the sale status of the property, options include:
 * AVAILABLE - the property is on the market and no one has made an offer
 * OFFER - an offer has been made on the property, but the parties are not yet in contract
 * CONTRACT - the parties are in contract, but have not yet closed escrow
 * ESCROW - the parties have closed escrow and the Property is now officially sold and off the market.
 * 
 * @author Alex
 *
 */

public enum Sale {
	
	AVAILABLE("A"), OFFER("O"), CONTRACT("C"), ESCROW("E");
	
	private String saleCode;
	
	private Sale(String saleCode) {
		this.saleCode = saleCode;
	}
	
	public String getSaleCode() {
		return saleCode;
	}
}
