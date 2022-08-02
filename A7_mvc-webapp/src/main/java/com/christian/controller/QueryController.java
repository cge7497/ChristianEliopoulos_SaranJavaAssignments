package com.christian.controller;

import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.christian.model.Employees;

@WebServlet("/queryData")
public class QueryController extends HttpServlet{
	//Handles create and update. (Update is technically a put operation, but html forms do not have this method).
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		if (req.getParameter("up_id") != null) {
			int id = Integer.parseInt(req.getParameter("up_id"));
			String name = req.getParameter("up_name");
			String age = req.getParameter("up_age");
			try {
				Employees.updateEmployee(id, name, age);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("cr_id")!=null){
			int id = Integer.parseInt(req.getParameter("cr_id"));
			String name = req.getParameter("cr_name");
			String age = req.getParameter("cr_age");
			try {
				Employees.updateEmployee(id, name, age);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	//Handles read and delete. (Delete is technically not a get operation, but html forms do not have this method),
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		if (req.getParameter("r_id") != null) {
			int id = Integer.parseInt(req.getParameter("r_id"));
			try {
				Employees.getEmployee(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("del_id")!=null){
			int id = Integer.parseInt(req.getParameter("up_id"));
			try {
				Employees.deleteEmployee(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
