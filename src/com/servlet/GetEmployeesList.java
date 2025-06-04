package com.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.*;
import com.dao.DBConnection;

import org.json.*;

/**
 * Servlet implementation class GetEmployeesList
 */
@WebServlet("/GetEmployeesList")
public class GetEmployeesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeesList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Employee> employees=DBConnection.getEmployeeList();
		JSONArray array=new JSONArray();
		for(Employee emp:employees) {
			JSONObject employee=new JSONObject();
			employee.put("id", emp.getId());
			employee.put("name", emp.getName());
			employee.put("status", emp.getStatus());
			array.put(employee);
		}
		response.setContentType("application/json");
		response.getWriter().write(array.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
