package com.christian.model;

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

}
