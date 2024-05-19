package com.ims.controler;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ims.model.DAOServiceImpl;


@WebServlet("/viewInquiry")
public class ViewInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewInquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//use the session object which is already created before
			HttpSession session = request.getSession(false);
			//set session time for 300 second 
			session.setMaxInactiveInterval(300);
			if(session.getAttribute("email")!=null) {
				DAOServiceImpl service= new DAOServiceImpl();
				service.connectDB();
				
				ResultSet result = service.viewEnquiries();
				
				//we want to print content on HTML or JSP page by using below process
				request.setAttribute("res",result);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/viewInquiry.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			
			//we want to print content on HTML or JSP page by using below process
			request.setAttribute("res","session timeOut!!");
			//if session out then connect this page with login.jsp page using RequestDispatcher
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}				
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
