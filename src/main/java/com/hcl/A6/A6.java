package com.hcl.A6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.InputMismatchException;
import java.util.Scanner;


public class A6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/A6?user=root");
        
        // setupDatabase(con); //Uncomment this in order to set up database.
        
        Scanner scanner = new Scanner(System.in);
        // Infinite loop of getting user input.
        while (true) {
        	System.out.println("What would you like to do? (Type 'get', 'get all', 'update', or 'delete')");
        	String input = scanner.nextLine().trim();
        	int id;
        	
        	switch (input) {
        		case "get all":
        			getEmployees(con);
        			break;
        		case "update":
        			id = getId(scanner);
        			if (id == -1) break;
        			updateEmployee(id, con, scanner);        	
        			break;
        		case "delete":
        			id = getId(scanner);
        			if (id == -1) break;
        			deleteEmployee(id, con);        				            		
        			break;
        		case "get":
        			id = getId(scanner);
        			if (id == -1) break;
        			getEmployee(id, con);            		
        			break;
        	}
        }
    }
    
    private static void getEmployee(int id, Connection con) throws SQLException {
        PreparedStatement pst=con.prepareStatement("select * from emp where id=?");
        pst.setInt(1, id);
        ResultSet emp=pst.executeQuery();
        
        printData(emp); 	
	}

	private static void deleteEmployee(int id, Connection con) throws SQLException {
        /* This relies on a stored procedure in the MySQL database. Here's that code:
        CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteEmp`(in empid numeric(10))
        		BEGIN
        		   delete from emp where id = empid;
        		END
         */
        CallableStatement cst=con.prepareCall("{call deleteEmp(?)}");
        cst.setInt(1, id);
        cst.execute();
        int x = cst.getUpdateCount();
        
        if (x==0) {
        	System.out.println("Failure- No employees deleted. Please choose an existing id.");
        }
        else if (x == 1) {
        	System.out.println("Deleted Employee with id " + id);
        }
        System.out.println();
}

	private static void getEmployees(Connection con) throws SQLException {
        PreparedStatement pst=con.prepareStatement("select * from emp");
        ResultSet emps=pst.executeQuery();
        printData(emps);
	}

	private static void updateEmployee(int id, Connection con, Scanner scanner) throws SQLException {
		boolean goodInput = false;
		String attrib = "";
		
		while (goodInput == false) {
			System.out.println("Which attribute would you like to change? (Type 'name' or 'age') ");
			attrib = scanner.nextLine().trim();
			
			if (attrib.equals("name") || attrib.equals("age")) {
				goodInput = true;
			}
		}
		System.out.println("What would you like to change the " + attrib + " to? ");
		String value = scanner.nextLine();
		
		// I put attrib in the string rather than as a ? parameter because doing so results in an SQL error.
		// Based on research, it seems like prepareStatement optimizes based on the query, and does not anticipate me making a column name a parameter.
        PreparedStatement pst=con.prepareStatement("update emp set " + attrib + "=? where id=?");
        pst.setString(1, value);
        pst.setInt(2, id);
        int x=pst.executeUpdate();
        
        if (x == 0) {
        	System.out.println("Failure- No employees updated. Please choose an existing id");
        }
        else if (x == 1) {
        	System.out.println("Updated " + x + " Employee with id " + id);
        }
        System.out.println();
	}

	static int getId(Scanner scanner) {
		System.out.println("What is the employee's id? (Enter -1 to go back to command select)");
		int i = 0;
		boolean goodId = false;
		while (!goodId) {
		try {
			i =scanner.nextInt();
			goodId = true;
			scanner.nextLine(); // I run this so that this line isn't read at nextLine in the main while loop, which results in a double print of the intro message..
		}
		catch (InputMismatchException e) {
			System.out.println("Please enter an integer for the id.");
		}
		}
		return i;
	}
	
	private static void printData(ResultSet set) throws SQLException {
		ResultSetMetaData data = set.getMetaData();
		int cols = data.getColumnCount();
		int rowCount = 0;
		
		// Prints out column names.
		for (int i = 1; i <= cols; i++) {
			System.out.print(data.getColumnName(i) + '\t');
		}
		System.out.println();
		
		// Loops through rows
		while(set.next()) {
			rowCount++;
			// Prints out each column attribute of row
			for (int i = 1; i <= cols; i++) {
				System.out.print(set.getString(i) + '\t');
			}
			System.out.println();
		}
		// If there were no rows, meaning an empty table was returned.
		if (rowCount == 0) {
			System.out.println("No rows returned. Try a different id");
		}
		System.out.println();
		
	}
	
	 // Sets up all of the data in the database. 
	// The call to it is commented out as a duplicate key error would occur if it was run again.
	static void setupDatabase(Connection con) throws SQLException {
        CallableStatement cst=con.prepareCall("{call insertEmp(?,?,?)}");
        /* This relies on a stored procedure in the MySQL database. Here's that code:
		CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmp`(in empid numeric(10),in empname varchar(100),in empage numeric(10))
			BEGIN
   				insert into emp values (empid, empname, empage);
			END
         */
        cst.setInt(1, 1);
        cst.setString(2, "Kris");
        cst.setInt(3, 22);
        cst.execute();
        cst.setInt(1, 2);
        cst.setString(2, "Eric");
        cst.setInt(3, 45);
        cst.execute();
        cst.setInt(1, 3);
        cst.setString(2, "Alex");
        cst.setInt(3, 26);
        cst.execute();
        cst.setInt(1, 4);
        cst.setString(2, "Isaac");
        cst.setInt(3, 35);
        cst.execute();
        cst.setInt(1, 5);
        cst.setString(2, "Angela");
        cst.setInt(3, 30);
        cst.execute();
        cst.setInt(1, 6);
        cst.setString(2, "Mary");
        cst.setInt(3, 23);
        cst.execute();
        cst.setInt(1, 7);
        cst.setString(2, "Rachel");
        cst.setInt(3, 40);
        cst.execute();
	}
    
}
