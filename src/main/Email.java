package main;

import java.util.Scanner;

public class Email {
	private String firstName; 
	private String lastName; 
	private String password; 
	private String department;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10 ; 
	private String alternateEmail; 
	private String companySuffix = "company.com"; 
	
	//Constructor to receive the first name and last name 
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.print("EMAIL CREATED: " + this.firstName+" "+ this.lastName);
		
	// Call a method asking for the department - return the department 
				this.department = setDepartment() ; 
				System.out.println("Department: " + this.department);
				
	// Call a method that returns a random password 
				this.password = randomPassword(defaultPasswordLength);
				System.out.println("Your password is: " + this.password);
				
	// combine elements to generate email 
				alternateEmail = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
				System.out.println("Your email is: " + alternateEmail);
	}
	
	//Ask for the random password 
	private String setDepartment() {
		System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice= in.nextInt();     
		if (depChoice == 1) { return "Sales";}
		else if (depChoice == 2) { return "dev";}
		else if (depChoice == 3) { return "acct";}
		else { return "";}
	}
	
	// Generate a random password 
	private String randomPassword(int length) {
		String passwordset = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordset.length());
			password[i] = passwordset.charAt(rand);
		}
		return new String (password); 
	}
	//Set the mailbox capacity 
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	//Set the alternative email 
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;  
	}
	//Change the password 
	public void setChangePassword(String password) {
		this.password = password;
	}
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail; }
	public String getPasssword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME:" + firstName + " " + lastName + 
				"\nCOMPANY EMAIL:  " + alternateEmail + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
