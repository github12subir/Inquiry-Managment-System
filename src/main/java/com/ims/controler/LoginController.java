package com.ims.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			DAOServiceImpl service= new DAOServiceImpl();
			service.connectDB();
			
			boolean status = service.verifyLogin(email, password);
			if(status) { //when status will be true 
				
				//create a session object
				HttpSession session = request.getSession(true);
				//set email into this session object
				session.setAttribute("email", email);
				//set session time for 300 second 
				session.setMaxInactiveInterval(300);
				//set login message
				request.setAttribute("LoginMsg","Successfully LogedIn! welcome in your Account");
				//connect this page with home.jsp  page using RequestDispatcher
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
				rd.forward(request, response);
				
			}else { //when status will be false
				//System.out.println("Invalid email/password ! try again");
				
				//we want to print content on HTML or JSP page by using below process
				request.setAttribute("LoginMsg", "Invalid email/password ! try again");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			//we want to print content on HTML or JSP page by using below process
			request.setAttribute("LoginMsg", "session timeOut!!");
			//if session out then connect this page with login.jsp page using RequestDispatcher
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
