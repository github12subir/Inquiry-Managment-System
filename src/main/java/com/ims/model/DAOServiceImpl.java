package com.ims.model;
import java.sql.*;

//create a implement class which will be implement All unImplement methods of DAOService interface
public class DAOServiceImpl implements DAOService{

	//override all UnImplement method inside this class
	
	//create a private type statement & assign Null value in it
	private Statement smt=null; //Non-Static member
	
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
	public boolean signUp(String email, String password) {
		
		try {
			ResultSet res = smt.executeQuery(" select * from login where email= '"+email+"' ");
			if(res.next()) {
				return false;//System.out.println("email already exist!!");
				
			}else {
				smt.executeUpdate("insert into login values('"+email+"','"+password+"')");
				return true;
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public String verifyLogin(String email, String password) {
		
		try {
			ResultSet res = smt.executeQuery("select email from login where email= '"+email+"' and password='"+password+"'");
			res.next();
			String userEmail=res.getString("email");
			return userEmail;
			//return res.next(); //if query row match it will be return automatically true
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//return false; // if query row not match it will be return automatically false
		return null;
	}

	@Override
	public void addEnquery(String name, String email, String phNumber, String course) {
		
		try {
			smt.executeUpdate("insert into student values('"+name+"','"+email+"','"+phNumber+"','"+course+"')");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteEnquery(String email) {
		
		try {
			smt.executeUpdate("delete from student where email='"+email+"'");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateEnquery(String email, String phNumber) {
		
		try {
			smt.executeUpdate("update student set phNumber='"+phNumber+"' where email='"+email+"'");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void closeDB() {
		
		
	}

}
