package receipt;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ReceiptQueue queue = new ReceiptQueue ();

		System.out.println("*******************************");
		System.out.println("*      RECEIPT GENERATOR      *");
		System.out.println("*******************************");

		while (true) {
			try {
				System.out.println("\n+-----------------------------+");
				System.out.println("|     Pat's Keyboard Shop     |");
				System.out.println("+-----------------------------+");
				System.out.println("|1. Display Queue             |");
				System.out.println("|2. Add Purchase              |");
				System.out.println("|3. Generate Receipt          |");
				System.out.println("|4. Exit                      |");
				System.out.println("+-----------------------------+");

				System.out.print("Choose Option: ");
				int choose = sc.nextInt();

				switch (choose) {

				case 1:
					queue.displayReceiptQueue();
					break;

				case 2:
					String yes_no;
					do {
						sc.nextLine();
						String itemName = "";
						while(true) {
							System.out.print("Enter Item Name: ");
							itemName = sc.nextLine();
							if (itemName.matches("^[a-zA-z]+$") && itemName.length() <= 12) {
								break;
							} else {
								System.out.println("Invalid Input! Please enter a valid item name (12 characters max).\n");
							}
						}

						double itemPrice = 0;
						while(true) {
							System.out.print("Enter Item Price: ");
							if (sc.hasNextDouble()){
								itemPrice = sc.nextDouble();
								break;
							} else {
								System.out.println("Invalid Input! Please enter a valid item price.");
								sc.next();
							}
						}
						Purchase purchase = new Purchase(itemName, itemPrice);
						queue.addPurchase(purchase);

						System.out.print("Add another purchase? [Y|N]: ");
						yes_no = sc.next();
					}
					while (yes_no.equalsIgnoreCase("y" + "n"));
					break;

				case 3:
					queue.generateReceipt();
					break;

				case 4:
					System.out.println("Thanks for using Pat's Keyboard Shop! Have a nice day!");
					sc.close();
					System.exit(0);
					break;

				default:
				System.out.println("Invalid Input! Please enter options [1 - 4] only.");

				}
			} catch (InputMismatchException  e) {
				System.out.println("Invalid Input! Please enter options [1 - 4] only.");
				sc.nextLine();
			}
		}
	}
}
