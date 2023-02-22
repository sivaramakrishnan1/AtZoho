import java.util.Scanner;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

class Portal {
	int customerIdGenerator = 1001, invoiceIdGenerator = 1001, itemIdGenerator = 1001, contentIdGenerator = 1001;
	List<Item> items = new ArrayList<>();
	List<Content> contents = new ArrayList<>();
	List<Customer> customers = new ArrayList<>();
	List<Invoice> invoices = new ArrayList<>();
	Scanner s = new Scanner(System.in);

	public static void mainmenu() {
		Portal p = new Portal();
		p.menu();
	}

	public void menu() {
		out: while (true) {
			System.out.print("\n\n\t\tMenu \n" + "\t\t1. Create Customer\n" + "\t\t2. Create Item\n"
					+ "\t\t3. Generate invoice\n" + "\t\t4. Edit item\n" + "\t\t5. Print invoices of a customer\n"
					+ "\t\t6. Print invoice by ID\n" + "\t\t7. Print all invoices\n"
					+ "\t\t8. Print all invoices in a duration\n" + "\t\t9. Print most sold item\n"
					+ "\t\t10. Most sold item in a duration\n" + "\t\t11. Exit\n" + "\n\t\t Choose an option : ");
			int choice = s.nextInt();

			switch (choice) {
			case 1:
				createCustomer();
				break;
			case 2:
				createItem();
				break;
			case 3:
				createInvoice();
				break;
			case 4:
				editItem();
				break;

			case 5:
				printInvoiceByCustomerId();
				break;

			case 11:
				break out;
			}
			s.close();
		}
	}

	void createCustomer() {
		System.out.print("\nEnter name : ");
		String name = s.nextLine();

		System.out.print("\nEnter phone number : ");
		String phone = s.nextLine();

		customers.add(new Customer(customerIdGenerator++, name, phone));
		System.out.println("Customer created.");
	}

	void createItem() {
		System.out.print("\nEnter product name : ");
		String name = s.next();

		System.out.print("\nEnter product's price : ");
		double price = s.nextDouble();

		items.add(new Item(itemIdGenerator++, name, price));
		System.out.println("Item created.");
	}

	void createInvoice() {
		int invoiceid = invoiceIdGenerator++;

		System.out.println("Enter customer phone number");
		String phone = s.next();
		int cadress = getCustomerId(phone);

		if (cadress == -1) {
			System.out.println("Unable to find the customer.");
			return;
		}

		System.out.println("Enter item count : ");
		int size = s.nextInt();
		double grandTotal = 0;

		Content[] contentsOfInvoice = new Content[size];

		for (int i = 0; i < size; i++) {
			System.out.println("Enter product id : ");
			int paddress = getProductAddressById(s.nextInt());
			if (paddress == -1) {
				System.out.println("Item not found! Try again");
				i--;
				continue;
			}
			double quantity = s.nextDouble();

			contentsOfInvoice[i] = new Content(contentIdGenerator++, invoiceid, items.get(paddress).prodName,
					items.get(paddress).price, quantity);
			contents.add(contentsOfInvoice[i]);
			grandTotal += items.get(paddress).price;
		}

		Date currDate = new Date();
		invoices.add(new Invoice(invoiceIdGenerator++, customers.get(cadress).custId, contentsOfInvoice, currDate,
				grandTotal));
	}

	int getCustomerId(String phone) {
		for (int i = 0; i < customers.size(); i++)
			if (phone.equals(customers.get(i).phone))
				return i;

		return -1;
	}

	int getProductAddressById(int id) {
		for (int i = 0; i < items.size(); i++)
			if (items.get(i).prodId == id)
				return i;

		return -1;
	}

	void editItem() {
		System.out.println("Enter Item id : ");
		int id = s.nextInt();

		for (Item item : items) {
			if (item.prodId == id) {
				item.toString();
				System.out.println("1. Change Name \n2. Change price");
				int choice = s.nextInt();
				if (choice == 1) {
					System.out.println("Enter new name : ");
					String name = s.next();
					item.prodName = name;
					System.out.println("Updated.");
					return;
				} else if (choice == 2) {
					System.out.println("Enter new price : ");
					double price = s.nextDouble();
					item.price = price;
					System.out.println("Updated.");
					return;
				} else {
					System.out.println("Invalid input!");
					return;
				}
			}
		}
	}

	void printInvoiceByCustomerId() {
		System.out.println("Enter the customer phone number : ");
		int paddress = getCustomerId(s.next());

		if (paddress == -1) {
			System.out.println("Can't find the customer.");
			return;
		}

		int custId = customers.get(paddress).custId;

		for (int i = 0; i < invoices.size(); i++) {
			if (invoices.get(i).custId == custId)
				System.out.println(invoices.get(i).toString() + "\n\n");
		}
	}

	void printInvoiceById() {
		int invId = s.nextInt();

		for (int i = 0; i < invoices.size(); i++) {
			if (invoices.get(i).invoiceId == invId) {
				System.out.println(invoices.get(i).toString());
			}
		}
	}

	void printAllInvoice() {
		for (int i = 0; i < invoices.size(); i++) {
			System.out.println(invoices.get(i).toString());
		}
	}

	void printInvoiceInDuration() {
		System.out.println("Enter FROM (Date Month Year): ");
		Date from = new Date(s.nextInt(), s.nextInt(), s.nextInt());
		System.out.println("Enter FROM (Date Month Year): ");
		Date to = new Date(s.nextInt(), s.nextInt(), s.nextInt());
		
	}

	void mostSoldItem() {

	}

	void mostSoldItemInDuration() {

	}
}