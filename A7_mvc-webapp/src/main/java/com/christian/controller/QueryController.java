package com.christian.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.christian.dao.EmployeeDAO;
import com.christian.model.Employee;

@WebServlet("/queryData")
public class QueryController extends HttpServlet{
	//Handles create and update. (Update is technically a put operation, but html forms do not have this method).
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 RequestDispatcher rd=req.getRequestDispatcher("displayResult.jsp");
		if (req.getParameter("operator") == "update") {
			int id = Integer.parseInt(req.getParameter("up_id"));
			String name = req.getParameter("up_name");
			String age = req.getParameter("up_age");
			try {
				int emp = EmployeeDAO.updateEmployee(id, name, age);
				req.setAttribute("amt", emp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (req.getParameter("operator") == "create"){
			int id = Integer.parseInt(req.getParameter("cr_id"));
			String name = req.getParameter("cr_name");
			int age = Integer.parseInt(req.getParameter("cr_age"));
			try {
				EmployeeDAO.createEmployee(id, name, age);
				int emp = EmployeeDAO.createEmployee(id, name, age);
				req.setAttribute("amt", emp);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		rd.forward(req, res);
	}
	//Handles read and delete. (Delete is technically not a get operation, but html forms do not have this method),
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("displayResult.jsp");
		if (req.getParameter("operator") == "read") {
			int id = Integer.parseInt(req.getParameter("r_id"));
			try {
				List<Employee> emps = EmployeeDAO.getEmployee(id);
				req.setAttribute("emp", emps);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (req.getParameter("operator") == "delete") {
			int id = Integer.parseInt(req.getParameter("up_id"));
			try {
				int amt = EmployeeDAO.deleteEmployee(id);
				req.setAttribute("amt", amt);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rd.forward(req, res);
	}
}
