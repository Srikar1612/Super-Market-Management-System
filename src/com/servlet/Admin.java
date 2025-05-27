package com.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Admin")

public class Admin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public Admin() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("UserName");
		String pwd=request.getParameter("Password");
      
		try{
			if(uid.equals("Admin") && pwd.equals("Admin"))
        {
        	response.sendRedirect("admin_home.jsp");
        }else{
        	PrintWriter pw=response.getWriter();
        	pw.println("<script type=\"text/javascript\">");
        	pw.println("alert('failed to login');");
        	pw.println("window.location='index.html'</script>");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

}
	}
}
