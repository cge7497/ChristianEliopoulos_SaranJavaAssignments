package com.christian.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.christian.model.Employee;

public class EmployeeDAO {
	
	private static Connection con;
	private static Connection getCon() throws ClassNotFoundException, SQLException {
		if (con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A6?user=root");
		}
		return con;
			
	}
	
	/*
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A6?user=root");

		// setupDatabase(con); //Uncomment this in order to set up database.
	}
	*/
	// This will only return 1 employee. I return a list because it fits the the logic in displayResults.jsp.
	public static List<Employee> getEmployee(int id) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = getCon().prepareStatement("select * from emp where id=?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();

		Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3));
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(emp);
		return emps;
	}

	public static int deleteEmployee(int id) throws SQLException, ClassNotFoundException {
		/*
		 * This relies on a stored procedure in the MySQL database. Here's that code:
		 * CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteEmp`(in empid numeric(10))
		 * BEGIN delete from emp where id = empid; END
		 */
		CallableStatement cst = getCon().prepareCall("{call deleteEmp(?)}");
		cst.setInt(1, id);
		cst.execute();
		int x = cst.getUpdateCount();

		if (x == 0) {
			System.out.println("Failure- No employees deleted. Please choose an existing id.");
		} else if (x == 1) {
			System.out.println("Deleted Employee with id " + id);
		}
		System.out.println();
		return x;
	}

	public static int updateEmployee(int id, String attrib, String val) throws SQLException, ClassNotFoundException {
		
		// I put attrib in the string rather than as a ? parameter because doing so results in an SQL error.
		// Based on research, it seems like prepareStatement optimizes based on the
		// query, and does not anticipate me making a column name a parameter.
		PreparedStatement pst = getCon().prepareStatement("update emp set " + attrib + "=? where id=?");
		pst.setString(1, val);
		pst.setInt(2, id);
		int x = pst.executeUpdate();

		return x;
	}

	public static int createEmployee(int id, String name, int age) throws ClassNotFoundException, SQLException {
		CallableStatement cst = getCon().prepareCall("{call insertEmp(?,?,?)}");
		cst.setInt(1, id);
		cst.setString(2, name);
		cst.setInt(3, age);
		int num = cst.executeUpdate();

		return num;

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
		while (set.next()) {
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
	// The call to it is commented out as a duplicate key error would occur if it
	// was run again.
	static void setupDatabase(Connection con) throws SQLException {
		CallableStatement cst = con.prepareCall("{call insertEmp(?,?,?)}");
		/*
		 * This relies on a stored procedure in the MySQL database. Here's that code:
		 * CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmp`(in empid
		 * numeric(10),in empname varchar(100),in empage numeric(10)) BEGIN insert into
		 * emp values (empid, empname, empage); END
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
