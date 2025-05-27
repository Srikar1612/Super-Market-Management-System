package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.DBConnection;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet("/EmployeeAdd")
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter o = response.getWriter();
		String eid = request.getParameter("e_ID");
		String Name = request.getParameter("e_Name");
		String Phone = request.getParameter("e_Phone");
		String Age = request.getParameter("e_Age");
		String Email = request.getParameter("e_Email");
		String Gender = request.getParameter("e_Gender");
		String Pass = request.getParameter("e_Pass");
		UserBean ub = new UserBean();
		ub.setEid(eid);
		ub.setName(Name);
		ub.setPhone(Phone);
		ub.setEmail(Email);
		ub.setAge(Age);
		ub.setGender(Gender);
		ub.setPassword(Pass);
		String sql = "insert into employee(E_ID, Name, Phone, Email, Age, Gender, Password) values(?,?,?,?,?,?,?);";
		int i = DBConnection.setEmployee(sql, ub);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Employee Register Successfully...');");
			o.println("window.location='admin_home.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Please enter valid Details/Already Exist');");
			o.println("window.location='admin_home.jsp';</script>");
		}
	}

}
