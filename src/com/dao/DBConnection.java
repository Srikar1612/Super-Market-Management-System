package com.dao;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;

import com.bean.UserBean;

public class DBConnection {
	public static Connection connect(){
		Connection con=null;
		String url= System.getenv("DATABASE_URL");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
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

public static int getAge(String sql3) {
		// TODO Auto-generated method stub
		Connection con = connect();
		String Age="";
		try {
			PreparedStatement ps=con.prepareStatement(sql3);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Age=rs.getString(1);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(Age);
	}
	
	public static JSONObject fetchUser(String sql) {
		Connection con=connect();
		ResultSet rs;
		JSONObject json=new JSONObject();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				json.put("name",rs.getString("Name"));
				json.put("phone",rs.getString("Phone"));
				json.put("email", rs.getString("Email"));
				json.put("age",rs.getString("Age"));
			}
			ps.close();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return json;
	}

	public static boolean delete(String sql) {
		// TODO Auto-generated method stub
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			i=ps.executeUpdate();
			ps.close();
			con.close();
			return i>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

public static List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		Connection con=connect();
		List<Employee> list=new ArrayList<Employee>();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setId(rs.getString("E_ID"));
				emp.setName(rs.getString("Name"));
				emp.setPhone(rs.getString("Phone"));
				emp.setAge(rs.getString("Age"));
				emp.setGender(rs.getString("Gender"));
				emp.setStatus(rs.getString("Status"));
				list.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static boolean updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		Connection con=connect();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("Update employee SET Status=? where E_ID= ?");
			ps.setString(1, status);
			ps.setString(2, id);
			i=ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0;
		
	}
	
}
