package ht.ch17;

import java.io.Serializable;

//AccountRecordSerializable class for serializable objects
public class AccountRecordSerializable implements Serializable{

	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	// no arguments constructor calls other constructor with default values
	public AccountRecordSerializable() {
		this(0, "", "", 0.0); // call four argument constructor
	}
	
	// initialize a record
	public AccountRecordSerializable(int acct, String first, String last, double bal) {
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
	}
	
	// set account number
	public void setAccount(int acct) {
		account = acct;
	}
	
	// get account number
	public int getAcccount() {
		return account;
	}
	
	// set first name
	public void setFirstName(String first) {
		firstName = first;
	}
	
	// get first name
	public String getFirstName() {
		return firstName;
	}
	
	// set last name
	public void setLastName(String last) {
		lastName = last;
	}
	
	// get last name
	public String getLastName() {
		return lastName;
	}
	
	// set balance
	public void setBalance(double bal) {
		balance = bal;
	}
	
	// get balance
	public double getBalance() {
		return balance;
	}
}
