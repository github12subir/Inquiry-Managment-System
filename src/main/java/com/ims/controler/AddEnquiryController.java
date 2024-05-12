package com.ims.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.model.DAOServiceImpl;
import java.sql.*;

@WebServlet("/addEnquiry")
public class AddEnquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddEnquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//read the data from frontend page by request object
				String name = request.getParameter("name");
				String  email= request.getParameter("email");
				String  phNumber= request.getParameter("phNumber");
				String  course= request.getParameter("course");
				
				//create a object of DAOServiceImpl class to call all methods of that class
				DAOServiceImpl service = new DAOServiceImpl();
				
				//connect the Controller Layer to the database in Model Layer using service object
				service.connectDB();
				service.addEnquery(name, email, phNumber, course);
				
				//we want to print content on html or jsp page by using below process
				request.setAttribute("Update", "You can Update your Details");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/update_Enquiry.jsp");
				rd.forward(request, response);
				
				
	}

}
