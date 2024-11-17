package ht.database;

//Person class that represents an entry in an address book.
public class Person {

	private int addressID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public Person() {
		
	}
	
	public Person(int id, String first, String last, String emailAddress, String phone) {
		setAddressID(id);
		setFirstName(first);
		setLastName(last);
		setEmail(emailAddress);
		setPhoneNumber(phone);
		
	}

	private void setPhoneNumber(String phone) {
		// TODO Auto-generated method stub
		phoneNumber = phone;
	}

	private void setEmail(String emailAddress) {
		// TODO Auto-generated method stub
		email = emailAddress;
	}

	private void setLastName(String last) {
		// TODO Auto-generated method stub
		lastName = last;
	}

	private void setFirstName(String first) {
		// TODO Auto-generated method stub
		firstName = first;
	}

	private void setAddressID(int id) {
		// TODO Auto-generated method stub
		addressID = id;
	}
	
	public int getAddressID() {
		return addressID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastame() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String toString() {
		return getAddressID() + getFirstName() + getLastame() + getEmail() + getPhoneNumber();
	}
	
}
