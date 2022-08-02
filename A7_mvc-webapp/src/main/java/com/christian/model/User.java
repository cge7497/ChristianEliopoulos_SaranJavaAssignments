package com.christian.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String username;
	private String password;
	private static Connection con;


	public String validateUserNamePwd() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A6?user=root");
		// System.out.println(con.toString());
		PreparedStatement ps = con.prepareCall("Select name from accounts where username = ? and password = ?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			return "";
		}
		else {
			return rs.getString(1);
		}
		
	}
	
	 /*
	// This could set up the database.I figured I should include them in case you wish to see how I created data.
	// Note to self: In order to run them, this file should be executed rather than run as a web app so that main executes.
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// setupAccounts(con);
	}
	*/
	private static void setupAccounts(Connection con) throws SQLException {
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

}
