package salesList;

import java.util.ArrayList;

public class salesSlip {
	// VARIABLES
	// Array list of SalesItems, mostly used for calculating total
	private ArrayList<SalesItem> masterSalesList;
	
	// CONSTRUCTOR
	public salesSlip() {
		this.masterSalesList = new ArrayList<>();
	}

	public ArrayList<SalesItem> getMasterSalesList() {
		return masterSalesList;
	}
	
	// Add Item does as it says, an will add a SalesItem to the SalesSlip array list
	public void addItem(SalesItem newItem) {
		masterSalesList.add(newItem);
	}
	
	// Item Total calculates the total of costs included in the array list, multiplying by the quantity, then returning 
	public String itemTotal(ArrayList<SalesItem> totList) {
		double total = 0;
		double tempItem = 0;
		for (int i = 0; i < totList.size(); i++) {
			tempItem = Double.parseDouble((totList.get(i)).getsPrice());
			tempItem *= Double.parseDouble((totList.get(i)).getsCount());
			total += tempItem;
		}
		
		return ("" + total);
	}

}
