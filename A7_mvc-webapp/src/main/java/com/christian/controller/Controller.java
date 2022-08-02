package com.christian.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.christian.model.User;
//Controller-> Navigates between your model and view
@WebServlet("/login")
public class Controller extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html");
		 String uname=req.getParameter("username");
		 String pwd=req.getParameter("password");
		 
		 User u1=new User();
		 u1.setUsername(uname);
		 u1.setPassword(pwd);
		 req.setAttribute("abc", u1);
		 
		String name = "";
		try {
			name = u1.validateUserNamePwd();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!name.isEmpty()) {
			 RequestDispatcher rd=req.getRequestDispatcher("loggedIn.jsp");
			 req.setAttribute("name", name);
			 rd.forward(req, res);
		
		 }else {
			 RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			 req.setAttribute("failure", true);
			 rd.forward(req, res);
		 }
	} 
		 protected void doGet(HttpServletRequest req,HttpServletResponse res)
					throws ServletException,IOException{
			 System.out.println(req.getAttribute("action"));
			 doPost(req,res);
		 }
	
}
