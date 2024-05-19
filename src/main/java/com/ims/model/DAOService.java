package com.ims.model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDB();
	public boolean verifyLogin(String email, String password);
	public ResultSet viewEnquiries();
	public void addEnquiry(String name, String email, String phNumber, String course);
	public void updateEnquiry(String email, String phNumber);
	public void deleteEnquiry(String email);
	public void closeDB();
}
