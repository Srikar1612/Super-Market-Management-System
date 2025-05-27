package com.dao;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;

import com.bean.UserBean;

public class DBConnection {
	public static Connection connect(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smms", "root", "root");
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		}
	}
	
	public static int setEmployee(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i=0;
		Connection con=connect();
		if (con == null) {
	        System.err.println("Connection is null. Cannot insert employee.");
	        return 0;
	    }
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ub.getEid());
			ps.setString(2, ub.getName());
			ps.setString(3, ub.getPhone());
			ps.setString(4, ub.getEmail());
			ps.setString(5, ub.getAge());
			ps.setString(6, ub.getGender());
			ps.setString(7, ub.getPassword());
			i=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b=false;
		Connection con=connect();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			b=rs.next();
			ps.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static String getEmail(String sql) {
		Connection con=connect();
		String email="";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				email=rs.getString(1);
			}
			ps.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return email;
	}

	public static String getName(String sql) {
		// TODO Auto-generated method stub
		Connection con=connect();
		String name="";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				name=rs.getString(1);
			}
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
}


