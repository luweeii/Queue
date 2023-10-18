package receipt;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;

class ReceiptQueue {
	private Deque<Purchase> queue = new ArrayDeque<>();
	private double bill = 0.00;
	private DecimalFormat df = new DecimalFormat("#.##");

	public void addPurchase(Purchase purchase) {
		queue.add(purchase);
		bill += purchase.price;
	}

	public void generateReceipt() {
		if(!queue.isEmpty()) {
			Purchase next = queue.poll();
			System.out.println("Receipt: " + next);
			bill -= next.price;
		} else {
			System.out.println("No available receipt to generate.");
		}
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public void displayReceiptQueue() {
		if (queue.isEmpty()) {
			System.out.println("Current Receipt Queue Status: [EMPTY]");
		} else {
			System.out.println("Current Receipt Queue Status:" );
			for(Purchase purchase : queue) {
				System.out.println(purchase);
			}
			System.out.println("Amount to pay: " + df.format(bill) + "php");
		}
	}
}
