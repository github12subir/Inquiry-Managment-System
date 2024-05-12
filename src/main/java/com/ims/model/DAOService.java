package com.ims.model;

//create a interface for abstraction -> data hiding
public interface DAOService {
	public void connectDB();
	public boolean signUp(String email, String password);
	public String verifyLogin(String email, String password);
	public void addEnquery(String name, String email, String phNumber, String course);
	public void deleteEnquery(String email);
	public void updateEnquery(String email, String phNumber);
	public void closeDB();
	
}
