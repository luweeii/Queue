package receipt;

import java.text.DecimalFormat;

class Purchase extends ReceiptQueue {
	String item;
	double price;

	public Purchase(String item, Double price) {
		this.item = item;
		this.price = price;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return "Item: " + item + " | Price: " + df.format(price) + "php";
	}
}


