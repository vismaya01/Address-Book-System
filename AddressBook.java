import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddressBook {
	Scanner scanner = new Scanner (System.in);
	ArrayList<PersonInfo> contact;
	Map<String,String> personCity;
	Map<String,String> personState;

	//constructor
	public AddressBook() {
		contact = new ArrayList<PersonInfo>();
		personCity = new HashMap<String, String>();
		personState = new HashMap<String, String>();
	}

	// add new person
	public void addPerson(Map<String,AddressBook> addressBook,AddressBook book) {
		System.out.println("Enter first name: ");
		String firstName = scanner.next();
		System.out.println("Enter the Last name: ");
		String lastName = scanner.next();
		System.out.println("Enter complete address: ");
		String address = scanner.next();
		System.out.println("Enter city: ");
		String city = scanner.next();
		System.out.println("Enter state: ");
		String state = scanner.next();
		System.out.println("Enter ZIP: ");
		String zip = scanner.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email id: ");
        String email = scanner.next();
        
        Iterator<PersonInfo> itr = contact.iterator();
		while(itr.hasNext()) {
			PersonInfo duplicate = itr.next();
			if(firstName.equals(duplicate.getFirstName()) && lastName.equals(duplicate.getLastName())) {
				System.out.println("Duplicate entry of contact");
				UserInput(addressBook,book);
			}
		}
		PersonInfo person = new PersonInfo(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println(person);
		contact.add(person);
		System.out.println("Contact added successfully");
	}

	//edit person details
	public void editPerson(String firstName, String lastName) {
		for(int i=0 ; i< contact.size() ;i++ ) {
                PersonInfo person = (PersonInfo)contact.get(i);
	            if (firstName.equals (person.getFirstName()) && lastName.equals (person.getLastName())) {
	            	System.out.println("Enter address: ");
	            	String address = scanner.next();
	            	System.out.println("Enter city: ");
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
	            	System.out.println(person);
	            	contact.add(person);
	            	contact.remove(i);
	            	System.out.println("Contact updated successfully\n");
	            	break;
	            }
		}
	}

	//delete person
	public void  deletePerson(String firstName, String lastName) {
		for(int i=0 ; i< contact.size() ;i++ ) {
               	PersonInfo person = (PersonInfo)contact.get(i);
  	            if (firstName.equals (person.getFirstName()) && lastName.equals (person.getLastName())) {
				contact.remove(i);
				System.out.println("Contact deleted successfully");
			}
		}
	}
	
	//search person
	public void searchPerson(Map<String, AddressBook> address,String city,String state) {
		for (AddressBook iterator : address.values()) {
			List<PersonInfo> addressBooks = iterator.contact;
			addressBooks.stream().forEach(addressBook -> {
	            if (city.equals(addressBook.getCity()) || state.equals (addressBook.getState())) {
	            	System.out.println(addressBook);
	            }
			});
		}
	}
	
	public void viewPerson(Map<String, AddressBook> address) {
		System.out.println("Enter the option");
		System.out.println("1.city");
		System.out.println("2.state");
		int choice = scanner.nextInt();
		for (AddressBook iterator : address.values()) {
			List<PersonInfo> addressBooks = iterator.contact;
			addressBooks.stream().forEach(addressBook -> {
	            personCity.put(addressBook.getFirstName(), addressBook.getCity());
	            personState.put(addressBook.getFirstName(), addressBook.getState());
			});
		}
		switch(choice) {
			case 1:
				int count = 0;
				for(Map.Entry m : personCity.entrySet()) {
					count = count + 1;
					System.out.println(m.getValue()+" "+m.getKey());
				}
				System.out.println("The number of contacts by city :"+count);
				break;
			case 2:
				int number = 0;
				for(Map.Entry m : personState.entrySet()) {
					number = number + 1;
					System.out.println(m.getValue()+" "+m.getKey());
				}
				System.out.println("The number of contacts by state :"+number);
				break;
			default:
				System.out.println("enter a valid option");
				break;
		}
	}
	
	//Sort person by name
	public void sortedPerson() {
		List<String> unsortedArrayName = new ArrayList<>();
		Iterator<PersonInfo> itr = contact.iterator();
		while(itr.hasNext()) {
				PersonInfo person = itr.next();
	            unsortedArrayName.add(person.getFirstName());
		}
		List<String> sortedList = unsortedArrayName.stream()
				.sorted().collect(Collectors.toList());
		
		List<PersonInfo> sortedAddressBook = new ArrayList<PersonInfo>();
		for(String sortedName : sortedList) {
			for (PersonInfo iterator : contact) {
				if(sortedName.equals(iterator.getFirstName()))
					sortedAddressBook.add(iterator);
			}
		}
		System.out.println("sortedList: "+sortedAddressBook);
	}

	
	public void UserInput(Map<String,AddressBook> addressBook,AddressBook book) {
		String firstName, lastName, city, state ;

		while(true){
			System.out.println("Select an action..");
			System.out.println("1. Add a person");
			System.out.println("2. Edit information");
			System.out.println("3. Delete a person");
			System.out.println("4. Disply person");
			System.out.println("5. view peron by city or state");
			System.out.println("6. sort the person");
			System.out.println("7. Quit");
			int choice = scanner.nextInt();
			
			System.out.println("Enter name of Address Book");
		    String addressBookName = scanner.next();
		    AddressBook address = addressBook.get(addressBookName);
			if (address == null) {
				address = new AddressBook();
				addressBook.put(addressBookName, address);
			}
			
			switch(choice) {
			case 1:
				addressBook.get(addressBookName).addPerson(addressBook,book);
				break;
			case 2:
				System.out.print("Enter first name and last name of the person to edit the contact: ");
				firstName = scanner.next();
				lastName = scanner.next();
				addressBook.get(addressBookName).editPerson(firstName,lastName);
				break;
			case 3:
				System.out.print("Enter first and last name of the person to delete the contact: ");
				firstName = scanner.next();
				lastName = scanner.next();
				addressBook.get(addressBookName).deletePerson(firstName,lastName);
				break;
			case 4:
				System.out.print("Enter city and state to view the contact: ");
				city = scanner.next();
				state = scanner.next();
				searchPerson(addressBook,city,state);
				break;
			case 5:
				viewPerson(addressBook);
				break;
			case 6:
				addressBook.get(addressBookName).sortedPerson();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Enter a valid option");
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		Map<String, AddressBook> addressBook = new HashMap<String, AddressBook>();
		
		AddressBook book = new AddressBook();
		book.UserInput(addressBook, book);
		
	}
}

