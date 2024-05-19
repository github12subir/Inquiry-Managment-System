package com.ims.model;

import java.sql.*;

public class DAOServiceImpl implements DAOService{

	private Statement smt= null;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imsdb","root","Test@123#321");
			smt=con.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet res = smt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return res.next();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void addEnquiry(String name, String email, String phNumber, String course) {
		
		try {
			smt.executeUpdate("insert into student values('"+name+"','"+email+"','"+phNumber+"','"+course+"')");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEnquiry(String email, String phNumber) {
		
		try {
			smt.executeUpdate("update student set phNumber='"+phNumber+"' where email='"+email+"'");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEnquiry(String email) {
		
		try {
			smt.executeUpdate("delete from student where email='"+email+"'");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeDB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet viewEnquiries() {
		try {
			ResultSet res = smt.executeQuery("select * from student");
			return res;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
