package com.ims.controler;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.model.DAOServiceImpl;


@WebServlet("/deleteInquiry")
public class DeleteInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteInquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);
		
		DAOServiceImpl service=new DAOServiceImpl();
		service.connectDB();
		service.deleteEnquiry(email);
		
		ResultSet result = service.viewEnquiries();		
		//we want to print content on HTML or JSP page by using below process
		request.setAttribute("res",result);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/viewInquiry.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}

}
