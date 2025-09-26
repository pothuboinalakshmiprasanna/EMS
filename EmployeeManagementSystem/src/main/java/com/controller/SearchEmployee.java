package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;


@WebServlet("/findByEmail")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String email=request.getParameter("email");
		EmployeeDAO dao=new EmployeeDAO();
		try {
			Employee employee= dao.getEmployee(email);
			if(employee.getId()==0) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("search.jsp");
				request.setAttribute("status", "Employee not found.....");
				dispatcher.forward(request, response);
			}
			else {
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewemp.jsp");
			request.setAttribute("employee", employee);
			dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
