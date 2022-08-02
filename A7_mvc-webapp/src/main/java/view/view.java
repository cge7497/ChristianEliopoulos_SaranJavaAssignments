package view;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class view {

	// Sets up all of the data in the database.
	// The call to it is commented out as a duplicate key error would occur if it
	// was run again.
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A6?user=root");
		// setupDatabase(con);
		setupAccount(con);
	}
	
	private static void setupAccount(Connection con) throws SQLException {
		CallableStatement cst = con.prepareCall("Insert into accounts values (?,?,?,?)");
		/*
		 * This relies on a stored procedure in the MySQL database. Here's that code:
		 * CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmp`(in empid
		 * numeric(10),in empname varchar(100),in empage numeric(10)) BEGIN insert into
		 * emp values (empid, empname, empage); END
		 */
		cst.setInt(1, 1);
		cst.setString(2, "test");
		cst.setString(3, "123");
		cst.setString(4, "Test user Bob");
		cst.execute();
		cst.setInt(1, 2);
		cst.setString(2, "christian");
		cst.setString(3, "assignment7");
		cst.setString(3, "Christian");

		cst.execute();
		cst.setInt(1, 3);
		cst.setString(2, "admin");
		cst.setString(3, "password");
		cst.setString(3, "Adnministrator");
		cst.execute();
	}

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
