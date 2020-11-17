import java.util.Scanner;

public class AddressBook {

	Scanner scanner = new Scanner (System.in);
	PersonInfo person;

	// add new person
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
		person = new PersonInfo(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println(person);
	}

	//edit person details
	public void editPerson(String firstName, String lastName) {
               	if (firstName.equals (person.getFirstName()) && lastName.equals (person.getLastName())) {
			System.out.print("Enter address: ");
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

			person = new PersonInfo(person.getFirstName(),person.getLastName(), address, city, state, zip, phoneNumber, email);
		}
		System.out.println("Contact updated successfully\n");
		System.out.println(person);
	}


	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		Scanner input = new Scanner (System.in);
		String firstName, lastName ;

		AddressBook address = new AddressBook();
		address.addPerson();

		System.out.print("Enter first name and last name of the person to edit the contact: ");
		firstName=input.next();
		lastName=input.next();
		address.editPerson(firstName,lastName);
	}
}

