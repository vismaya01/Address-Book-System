import java.util.Scanner;

public class AddressBook {

	Scanner scanner = new Scanner (System.in);

	public void addPerson() {
		System.out.print("Enter first name: ");
		String firstName = scanner.next();
		System.out.println("Enter the Last name: ");
		String lastName = scanner.next();
		System.out.print("Enter complete address: ");
		String address = scanner.next();
		System.out.print("Enter city: ");
		String city = scanner.next();
		System.out.println("Enter state: ");
		String state = scanner.next();
		System.out.println("Enter ZIP: ");
		String zip = scanner.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email id: ");
                String email = scanner.next();

		//construt new person object
		PersonInfo person = new PersonInfo(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println(person);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		AddressBook address = new AddressBook();
		address.addPerson();
	}
}

