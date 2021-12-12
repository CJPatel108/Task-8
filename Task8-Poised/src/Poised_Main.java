//CJ Patel
//Task8 - Poised_Main.java
/************************************************************/
import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.*;

/**
* The class illustrates the project management system for a small structural engineering firm called "Poised".
* Poised does the engineering needed to ensure the structural integrity of various buildings.
* This Java program keeps track of the many projects on which they work. 
* 
* @author CJ Patel
* @version 1.8.0_241, 17 May 2020
*/
public class Poised_Main {
	/**
	*
	* Main method
	* <br>
	* The method initialises the list variables
	* 
	*/
	public static void main(String [] args) {
		//create empty list of type project objects
		List<Project> project = new ArrayList<Project>();
		//create empty list of type person objects
		List<Person> person = new ArrayList<Person>();

		//read details about existing projects from a database
		try{
			readPoisedPMS(project, person);
		}catch(ParseException p){System.out.println("Error Reading Database");}

		//call method for menu
		menu(project, person);
	}
	/**
	*
	* Simple method
	* <br>
	* The method displays the menu
	* 
	* @param project list variable that stores all project objects
	* @param person list variable that stores all person objects
	* 
	*/
	//main menu
	public static void menu(List<Project> project, List<Person> person) {
		//create Scanner object
		Scanner in = new Scanner(System.in);
		char menuOption;
		//display menu and request input from user
		System.out.println("\nPlease select an option by entering the corresponding letter: ");
		System.out.println("A - Create Project");
		System.out.println("B - Create Person");
		System.out.println("C - View all projects");
		System.out.println("D - Edit existing data for a person");
		System.out.println("E - Finalise Project and Exit Program");

		menuOption = in.next().charAt(0);

		//create Scanner object
    	Scanner input = new Scanner(System.in);

		switch(menuOption) {
			case 'A':
				//call method to add values to object project
				createNewProject(project, person);
        		break;
			case 'B':
				//call method to add values to object person
				createNewPerson(project, person);
				break;
			case 'C':
				//call method to view all projects
				viewAll(project, person);
				break;
			case 'D':
				//call method to edit existing data for person
				editExistingDataPerson(project, person);				
				break;
			case 'E':
				//call method to finalise project and exit program
				exitProgram(project, person);
				break;
			default:
				//Terminate program if incorrect menuOption is entered
				System.out.println("Invalid input");
				System.out.println("Exiting program...");
				System.exit(0);
				//throw new IllegalArgumentException();
		}
	}
	/**
	*
	* Simple method
	* <br>
	* The method creates a new project element by asking users for input
	* 
	* @param project list variable that stores all project objects
	* @param person list variable that stores all person objects
	* 
	*/
	//add values to object project
	public static void createNewProject(List<Project> project, List<Person> person) {
		//create Scanner object
    	Scanner input = new Scanner(System.in);
    	try {
			//prompt user for values for object project
			System.out.println("\nPlease enter the project number: ");
	        int projectNumber = input.nextInt();
			//project.setProjectNumber(projectNumber);

	        System.out.println("Please enter the project name: ");
	        String projectName = input.nextLine();
	        projectName = input.nextLine();
			//project.setProjectName(projectName);

	        System.out.println("Please enter the type of building: ");
	        String typeOfBuilding = input.nextLine();
			//project.setTypeOfBuilding(typeOfBuilding);

	        System.out.println("Please enter the physical address: ");
			String physicalAddress = input.nextLine();
			//project.setPhysicalAddress(physicalAddress);

	        System.out.println("Please enter the ERF number: ");
	        String erfNumber = input.nextLine();
			//project.setErfNumber(erfNumber);

	        System.out.println("Please enter the total fee charged: ");
			double totalFeeCharged = input.nextDouble();
			//project.setTotalFeeCharged(totalFeeCharged);

	        System.out.println("Please enter the total amount paid to date: ");
	        double totalAmountPaidToDate = input.nextDouble();
			//project.setTotalAmountPaidToDate(totalAmountPaidToDate);

	        System.out.println("Please enter the deadline(dd/MM/yyyy): ");
	        String date = input.nextLine();
	        date = input.nextLine();
	        
			Date deadline = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			
			Project proj = new Project(projectNumber, projectName, typeOfBuilding, physicalAddress, erfNumber, totalFeeCharged, totalAmountPaidToDate, deadline);
			project.add(proj);

			//return to main menu
			System.out.println();
			System.out.println("Returning to main menu...");
			menu(project, person);
		}catch(Exception e){System.out.println("Error - Invalid Input");}
	}
	/**
	*
	* Simple method
	* <br>
	* The method creates a new person element by asking users for input
	* 
	* @param project list variable that stores all project elements
	* @param person list variable that stores all people elements
	* 
	*/
	//add values to object person
	public static void createNewPerson(List<Project> project, List<Person> person) {
		//create Scanner object
    	Scanner input = new Scanner(System.in);
    	//try{
			//prompt user for values for object person
			System.out.println("\nPlease enter a name: ");
			String name = input.nextLine();
			//person.setName(name);

	   		System.out.println("Please enter a telephone number: ");
	   		String telephoneNumber = input.nextLine();
			//person.setTelephoneNumber(telephoneNumber);

	   		System.out.println("Please enter an email address: ");
	  		String emailAddress = input.nextLine();
			//person.setEmailAddress(emailAddress);

	    	System.out.println("Please enter a physical address: ");
	    	String physicalAddress1 = input.nextLine();
			//person.setPhysicalAddress(physicalAddress1);

	    	Person pers = new Person(name, telephoneNumber, emailAddress, physicalAddress1);
			person.add(pers);

			//return to main menu
			System.out.println();
			System.out.println("Returning to main menu...");
			menu(project, person);
		//}catch(Exception e){System.out.println("Error - Invalid input");}
	}
	/**
	*
	* Simple method
	* <br>
	* The method reads data from PoisedPMS into the project list variable
	* 
	* @param project list variable that stores all projects
	* @param person list variable that stores all people
	*
	* @throws ParseException
	* 
	*/
	//read PoisedPMS
	public static void readPoisedPMS(List<Project> project, List<Person> person) throws ParseException{
		Scanner input = new Scanner(System.in);
		try(
			//Class.forName("com.mysql.jdbc.Driver");
			//Allocate a database 'Connection' object - changed password
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisedPMS?useSSL=false", "myuser", "newUser");
			//Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			){
				//Issue a SELECT
				String strSelect = "select * from project";
				System.out.println("The SQL query is: " + strSelect);
				ResultSet rset = stmt.executeQuery(strSelect);

				while(rset.next()){
					//System.out.println(rset.getInt("id") + ", " + rset.getString("Author") + ", " + rset.getString("Title") + ", " + rset.getInt("Qty"));
					//System.out.println(rset.getInt("projectNumber") + ", " + rset.getString("projectName") + ", " + rset.getString("typeOfBuilding") + ", " + rset.getString("physicalAddress") + ", " + rset.getString("erfNumber") + ", " + rset.getDouble("totalFeeCharged") + ", " + rset.getDouble("totalAmountPaidToDate") + ", " + rset.getString("deadline"));
					int projectNumber = rset.getInt("projectNumber");
					String projectName = rset.getString("projectName");
					String typeOfBuilding = rset.getString("typeOfBuilding");
					String physicalAddress = rset.getString("physicalAddress");
					String erfNumber = rset.getString("erfNumber");
					double totalFeeCharged = rset.getDouble("totalFeeCharged");
					double totalAmountPaidToDate = rset.getDouble("totalAmountPaidToDate");
					String date = rset.getString("deadline");

					Date deadline = new SimpleDateFormat("dd/MM/yyyy").parse(date);
					Project fileProject = new Project(projectNumber, projectName, typeOfBuilding, physicalAddress, erfNumber, totalFeeCharged, totalAmountPaidToDate, deadline);
					project.add(fileProject);
				}
				System.out.println("Read Project Complete...");
			} catch(SQLException ex){
				ex.printStackTrace();
			}

			// Scanner input = new Scanner(System.in);
			try(
			//Class.forName("com.mysql.jdbc.Driver");
			//Allocate a database 'Connection' object - changed password
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisedPMS?useSSL=false", "myuser", "newUser");
			//Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			){
				//Issue a SELECT
				String strSelect = "select * from person";
				System.out.println("The SQL query is: " + strSelect);
				ResultSet rset = stmt.executeQuery(strSelect);

				while(rset.next()){
					String name = rset.getString("name");
			   		String telephoneNumber = rset.getString("telephoneNumber");
					String emailAddress = rset.getString("emailAddress");
			    	String physicalAddress1 = rset.getString("physicalAddress");

			    	Person filePerson = new Person(name, telephoneNumber, emailAddress, physicalAddress1);
					person.add(filePerson);
				}
				System.out.println("Read Project Complete...");
			} catch(SQLException ex){
				ex.printStackTrace();
			}
	}
	/**
	*
	* Simple method
	* <br>
	* The method allows the editing of the objects in person list
	* 
	* @param project list variable that stores all project objects
	* @param person list variable that stores all person objects
	* 
	*/
	//edit objects in person list
	public static void editExistingDataPerson(List<Project> project, List<Person> person){
		//create Scanner object
    	Scanner input = new Scanner(System.in);
    	//no objects in list
    	if(person.size() == 0)
    	{
    		System.out.println("No details for any people have been added");
    		menu(project, person);
    	}
    	else
    	{
    		//print all objects of list for user to select
    		for (int i = 0; i < person.size(); i++) {
    			System.out.print("\n[" + i + "]");
    			System.out.println(person.get(i));
    		}
    	}

    	//Edit existing data
		System.out.println("Please select the number corresponding to the person: ");
		int selection = input.nextInt();
		
		System.out.println(person.get(selection));
		person.remove(selection);

		createNewPerson(project, person);
		int last = person.size()-1;
		person.set(selection, person.get(last));
			
		menu(project, person);	
	}
	/**
	*
	* Simple method
	* <br>
	* 
	* The method allows the user to view all project objects
	* The method allows the editing of the objects in the project list
	* The method allows the user to choose to see overdue project objects
	* 
	* @param project list variable that stores all projects
	* @param person list variable that stores all people
	* 
	*/
	//view all project objects 
	//edit objects in project list
	public static  void viewAll(List<Project> project, List<Person> person){
		//create Scanner object
    	Scanner input = new Scanner(System.in);
    	//print all projects objects for user to select from
		for(int i = 0; i < project.size(); i++)
		{
			System.out.println(project.get(i));
		}
		//print options
		System.out.println();
		System.out.println("A - Edit existing data for project");
		System.out.println("B - List Overdue projects");
		System.out.println("C - Return to main menu");
		char cOption =  input.next().charAt(0);

		switch(cOption){
			case 'A':
			//Edit existing data
				System.out.println("Please select the project number: ");
				int selection = input.nextInt();
				selection = selection - 1;

				System.out.println(project.get(selection));
				project.remove(selection);

				createNewProject(project, person);
				int last = project.size()-1;
				project.set(selection, project.get(last));
				//return to main menu
				menu(project, person);			
				break;
			case 'B':
			//List overdue projects
				//get current date
				Date today = Calendar.getInstance().getTime();
				System.out.println();
				System.out.println("The Following Projects are Overdue: ");
				//compare current date with project deadline
				for(int i = 0; i < project.size(); i++){
					Date projectDeadline = project.get(i).getDeadline();
					if (projectDeadline.compareTo(today) < 0)
					{
						System.out.println(project.get(i));
					}
				}
				//return to main menu
				menu(project, person);
				break;
			case 'C':
			//return to main menu
				menu(project, person);
				break;
			default:
				//Terminate program if incorrect menuOption is entered
				System.out.println("Invalid input");
				System.out.println("Exiting program...");
				System.exit(0);
				//throw new IllegalArgumentException();
		}
	}
	/**
	*
	* Simple method
	* <br>
	* 
	* The method writes the elements of the project list into the PoisedPMS database
	* The method then terminates the program
	* 
	* @param project list variable that stores all project objects
	* @param person list variable that stores all person objects
	* 
	*/
	public static void exitProgram(List<Project> project, List<Person> person){
		//create Scanner object
    	Scanner input = new Scanner(System.in);
		//Print out all details of project and person
		for(int i = 0; i < project.size(); i++)
		{
			System.out.println(project.get(i));
		}
		System.out.println(); //print empty line for readability
		System.out.println("A - Confirm All Details");
		System.out.println("B - Back to Main Menu");
		char confirm = input.next().charAt(0);

		switch(confirm){
			case 'A':
				//write list of project objects to poisedPMS
				System.out.println("Updating Database...");
				try(
				//Class.forName("com.mysql.jdbc.Driver");
				//Allocate a database 'Connection' object - changed password
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisedPMS?useSSL=false", "myuser", "newUser");
				//Allocate a 'Statement' object in the Connection
				Statement stmt = conn.createStatement();
				){
					//delete all data from database
					String sqlDelete = "delete * from project";
					System.out.println("The SQL query is: " + sqlDelete);
					//return an int indicating the number of rows affected
					int del = stmt.executeUpdate(sqlDelete);
					
					//insert all new data from list into database
					for(int i = 0; i < project.size(); i++)
					{
						String sqlInsert = "insert into project " + "values (" + project.get(i).getProjectNumber() + ", " + project.get(i).getProjectName() + ", "  + project.get(i).getTypeOfBuilding() + ", " + project.get(i).getPhysicalAddress() + ", " + project.get(i).getErfNumber() + ", " + project.get(i).getTotalFeeCharged() + ", " + project.get(i).getTotalAmountPaidToDate() + ", " + project.get(i).getDeadline() + ");";
						int ins = stmt.executeUpdate(sqlInsert);
					}
					System.out.println("Database was successfully updated...");
				} catch(SQLException ex){
					ex.printStackTrace();
				}
			
				//write list of person objects to poisedPMS
				try(
				//Class.forName("com.mysql.jdbc.Driver");
				//Allocate a database 'Connection' object - changed password
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PoisedPMS?useSSL=false", "myuser", "newUser");
				//Allocate a 'Statement' object in the Connection
				Statement stmt = conn.createStatement();
				){
					//delete all data from database
					String sqlDelete = "delete * from person";
					System.out.println("The SQL query is: " + sqlDelete);
					//return an int indicating the number of rows affected
					int del = stmt.executeUpdate(sqlDelete);
					
					//insert all new data from list into database
					for(int i = 0; i < person.size(); i++)
					{
						String sqlInsert = "insert into person " + "values (" + person.get(i).getName() + ", " + person.get(i).getTelephoneNumber() + ", "  + person.get(i).getEmailAddress() + ", " + person.get(i).getPhysicalAddress() + ");";
						int ins = stmt.executeUpdate(sqlInsert);
					}
					System.out.println("Database was successfully updated...");
				} catch(SQLException ex){
					ex.printStackTrace();
				}
				
				//Generate Invoice if need to
				for(int i = 0; i < project.size(); i++)
				{
					if(project.get(i).getTotalFeeCharged()-project.get(i).getTotalAmountPaidToDate() != 0)
					{
						System.out.println("INVOICE");
						System.out.println(person.get(i));
						//mark project as finalised and add completion date as today
						System.out.println("Finalised");
						Date today = Calendar.getInstance().getTime();
						System.out.println(today);
					}
				}
								
				//Exit program
				System.out.println("Exiting program...");
				break;
			case 'B':
			//return to main menu
				menu(project, person);
				break;
			default:
				//Terminate program if incorrect menuOption is entered
				System.out.println("Invalid input");
				System.out.println("Exiting program...");
				System.exit(0);
				//throw new IllegalArgumentException();
		}
		System.exit(0);
	}
}