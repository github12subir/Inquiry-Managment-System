package com.ims.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.model.DAOServiceImpl;


@WebServlet("/signup")
public class SignUp_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignUp_Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//read the data from frontend page by request object
		String email = request.getParameter("email");
		String  password= request.getParameter("password");
		
		//create a object of DAOServiceImpl class to call all methods of that class
		DAOServiceImpl service = new DAOServiceImpl();
		
		//connect the Controller Layer to the database in Model Layer using service object
		service.connectDB();
		
		
		
		 boolean status = service.signUp(email, password);
		 
		 if(status) {
			 request.setAttribute("error","signUp sucessful! plz login");
			 
		 }else {
			 request.setAttribute("error", "This email already exist!! try to login");
		 }
		 
		//when account or email already exist			
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
				
	}

}
