package salesList;

public class SalesItem {

	// VARIABLES
	// sItem is the item being sold
	// sPrice is the price of that item
	// sCount is the quantity of that item
	private String sItem;
	private String sPrice;
	private String sCount;

	// CONSTRUCTOR
	public SalesItem(String sItem, String sPrice, String sCount) {
		this.sItem = sItem;
		this.sPrice = sPrice;
		this.sCount = sCount;
	}

	public String getsItem() {
		return sItem;
	}

	public void setsItem(String sItem) {
		this.sItem = sItem;
	}

	public String getsPrice() {
		return sPrice;
	}

	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}

	public String getsCount() {
		return sCount;
	}

	public void setsCount(String sCount) {
		this.sCount = sCount;
	}
	
	// SALESITEM FUNCTIONS
	// toList simply generates the row including item, price, and quantity, then escapes to next line for the next row
	public String toList(SalesItem nextItem) {
		return (nextItem.sItem + "\t$" + nextItem.sPrice + "\t" + nextItem.sCount + "\n");
	}
	
}
