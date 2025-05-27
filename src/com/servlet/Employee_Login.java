package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnection;

/**
 * Servlet implementation class Employee_Login
 */
@WebServlet("/Employee_Login")
public class Employee_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Login() {
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
		doGet(request, response);
		String eid= request.getParameter("E_id");
		String pass=request.getParameter("Password");
		String sql="Select * from employee where E_id= '"+eid+"' AND Password='"+pass+"' AND Status='Active'";
		boolean b=DBConnection.getData(sql);
		HttpSession session=request.getSession();
		if(b==true) {
			String email=DBConnection.getEmail("select Email from employee where E_ID='"+eid+"';");
			session.setAttribute("email", email);
			sql = "select Name from employee where E_ID='"+eid+"';";
			String name = DBConnection.getName(sql);
			session.setAttribute("name", name);
			response.sendRedirect("employee_home.jsp");
		}else{
			PrintWriter o=response.getWriter();
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Incorrect credentials/Status is Inactive');");
			o.println("window.location='employee_login.jsp';</script>");
		}
	}

}
