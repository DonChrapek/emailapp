package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Call method that set department
		this.department = setDepartment();
		
		// Call method that set password
		this.password = randomPassword(this.defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Create email address
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + ".company.com";
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.print("Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for Other\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) { return "sales";}
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3) { return "acc"; }
		else { return ""; }
	}
	
	// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$?";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return this.mailboxCapacity; }
	public String getAlternateEmail() { return this.alternateEmail; }
	public String getPassword() { return this.password; }
	
	public String showInfo() {
		return "NAME: " + this.firstName + " " + this.lastName + "\n" +
				"EMAIL: " + this.email + "\n" + 
				"MAILBOX CAPACITY: " + this.mailboxCapacity + "mb";
	}
}
