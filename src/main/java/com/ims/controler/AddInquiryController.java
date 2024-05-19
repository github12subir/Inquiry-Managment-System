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
@WebServlet("/addInquiry")
public class AddInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddInquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/addInquiry.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//use the session object which is already created before
			HttpSession session = request.getSession(false);
			//set session time for 300 second 
			session.setMaxInactiveInterval(300);
			if(session.getAttribute("email")!=null) {
				//read the data from front-end page by request object
				String name = request.getParameter("name");
				String  email= request.getParameter("email");
				String  phNumber= request.getParameter("phNumber");
				String  course= request.getParameter("course");
				
				//create a object of DAOServiceImpl class to call all methods of that class
				DAOServiceImpl service = new DAOServiceImpl();
				
				//connect the Controller Layer to the database in Model Layer using service object
				service.connectDB();
								
				service.addEnquiry(name, email, phNumber, course);
										
				//we want to print content on HTML or JSP page by using below process
				request.setAttribute("AddMsg", "Your record is Saved!!");
				//Connect this page with home.jsp page using RequestDispatcher
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
				rd.forward(request, response);
			}else {
				
				//Connect this page with home.jsp page using RequestDispatcher
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}catch (Exception e) {
			//we want to print content on HTML or JSP page by using below process
			request.setAttribute("AddMsg", "session timeout!!");
			//if session out then connect this page with login.jsp page using RequestDispatcher
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
