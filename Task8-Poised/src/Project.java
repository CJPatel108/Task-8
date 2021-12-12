//CJ Patel
//Task8 - Project.java
/************************************************************/
import java.util.*;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Project //extends Customer?
{
	//Attributes
	private int projectNumber;
	private String projectName;
	private String typeOfBuilding;
	private String physicalAddress;
	private String erfNumber; //AlphaNumeric
	private double totalFeeCharged;
	private double totalAmountPaidToDate;
	private Date deadline; //Date converted to String

	//Methods
	public Project() {
		//default constructor, sets all values to null
	}
	public Project(int projectNumber, String projectName, String typeOfBuilding, String physicalAddress, String erfNumber, double totalFeeCharged, double totalAmountPaidToDate, Date deadline) {
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.typeOfBuilding = typeOfBuilding;
		this.physicalAddress = physicalAddress;
		this.erfNumber = erfNumber;
		this.totalFeeCharged = totalFeeCharged;
		this.totalAmountPaidToDate = totalAmountPaidToDate;
		this.deadline = deadline;		
	}
	public void setProjectNumber(int projectNumber)	{
		//System.out.println("projectNumber");  <!--test method call-->
		this.projectNumber = projectNumber;
	}
	public int getProjectNumber() {
		return projectNumber;
	}
	public void setProjectName(String projectName) {
		//System.out.println("projectName");  <!--test method call-->	
		this.projectName = projectName;	
	}
	public String getProjectName() {
		return projectName;
	}
	public void setTypeOfBuilding(String typeOfBuilding) {
		//System.out.println("typeOfBuilding");  <!--test method call-->
		this.typeOfBuilding = typeOfBuilding;
	}
	public String getTypeOfBuilding() {
		return typeOfBuilding;
	}
	public void setPhysicalAddress(String physicalAddress) {
		//System.out.println("physicalAddress");  <!--test method call-->
		this.physicalAddress = physicalAddress;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setErfNumber(String erfNumber) {
		//System.out.println("erfNumber");  <!--test method call-->
		this.erfNumber = erfNumber;
	}
	public String getErfNumber() {
		return erfNumber;
	}
	public void setTotalFeeCharged(double totalFeeCharged) {
		//System.out.println("totalFeeCharged");  <!--test method call-->
		this.totalFeeCharged = totalFeeCharged;
	}
	public double getTotalFeeCharged() {
		return totalFeeCharged;
	}
	public void setTotalAmountPaidToDate(double totalAmountPaidToDate) {
		//System.out.println("totalAmountPaidToDate");  <!--test method call-->
		this.totalAmountPaidToDate = totalAmountPaidToDate;
	}
	public double getTotalAmountPaidToDate() {
		return totalAmountPaidToDate;
	}
	public void setDeadline(Date deadline) {
		//System.out.println("deadline");  <!--test method call-->
		this.deadline = deadline;
	}
	public Date getDeadline() {
		return deadline;
	}
	public String toString() {
		String output = "\nProject Details - ";
		output += "\nProject Number: " + projectNumber;
		output += "\nProject Name: " + projectName;
		output += "\nType Of Building: " + typeOfBuilding;
		output += "\nPhysical Address: " + physicalAddress;
		output += "\nERF Number: " + erfNumber;
		output += "\nTotal Fee Charged: " + totalFeeCharged;
		output += "\nTotal Amount Paid To Date: " + totalAmountPaidToDate;

		String stringDeadline = new SimpleDateFormat("dd/MM/yyyy").format(deadline);

		output += "\nDeadline: " + stringDeadline;

		return output;
	}
}