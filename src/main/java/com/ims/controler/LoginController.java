package com.ims.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.model.DAOServiceImpl;


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
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
		
		//called the verifyLogin method
		String userEmail = service.verifyLogin(email, password); //pass two parameters
		
			if(userEmail != null) { //when status will be true 
				//System.out.println("Successfully LogedIn! welcome in your Account");
				request.setAttribute("userCode", userEmail);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/homePage.jsp");
				rd.forward(request, response);
				
			}else { //when status will be false
				//System.out.println("Invalid email/password ! try again");
				
				//we want to print content on html or jsp page by using below process
				request.setAttribute("error", "Invalid email/password ! try again");
				RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
				rd.forward(request, response);
			}
		
	}

}
