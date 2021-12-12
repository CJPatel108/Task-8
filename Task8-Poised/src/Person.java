//CJ Patel
//Task8 - Person.java
/************************************************************/
import java.util.*;
import java.util.Scanner;

public class Person
{
	//Attributes
	private String name;
	private String telephoneNumber;
	private String emailAddress;
	private String physicalAddress;

	//Methods
	public Person() {
		//default constructor, sets all values to null
	}
	public Person(String name, String telephoneNumber, String emailAddress, String physicalAddress)	{
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.physicalAddress = physicalAddress;
	}
	public void setName(String name) {
		//System.out.println("name");  <!--test method call-->
		this.name = name;
	}
	public String getName()	{
		return name;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		//System.out.println("telephoneNumber");  <!--test method call-->
		this.telephoneNumber = telephoneNumber;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setEmailAddress(String emailAddress)
	{
		//System.out.println("emailAddress");  <!--test method call-->
		this.emailAddress = emailAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		//System.out.println("physicalAddress");  <!--test method call--> 
		this.physicalAddress = physicalAddress;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public String toString() {
		String output = "\nPerson Information - ";
		output += "\nName: " + name;
		output += "\nTelephone Number: " + telephoneNumber;
		output += "\nEmail Address: " + emailAddress;
		output += "\nPhysical Address: " + physicalAddress;

		return output;
	}
}