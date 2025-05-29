package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnection;

/**
 * Servlet implementation class EmployeeDel
 */
@WebServlet("/EmployeeDel")
public class EmployeeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDel() {
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
		String id=request.getParameter("de_ID");
		String sql="select * from employee where E_ID= '"+id+"'";
		if(DBConnection.getData(sql)){
			String sql1= "delete from employee where E_ID= '"+id+"'";
			boolean b=DBConnection.delete(sql1);
			PrintWriter o=response.getWriter();
			if(b) {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Employee Deleted Successfully...');");
				o.println("window.location='admin_home.jsp';</script>");
			}
			else {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Please enter valid Details');");
				o.println("window.location='admin_home.jsp';</script>");
			}
		}
		
		
	}

}
