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


@WebServlet("/updateInquiry")
public class UpdateInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateInquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Read data from Front-end using request object
		String email = request.getParameter("email");
		String phNumber = request.getParameter("phNumber");
		
		//set email into this request object
		request.setAttribute("email", email);
		//set phNumber into this request object
		request.setAttribute("phNumber", phNumber);
		
		//connect this page with update_Enquiry.jsp page using RequestDispatcher
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/updateInquiry.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String phNumber = request.getParameter("phNumber");
		
		DAOServiceImpl service=new DAOServiceImpl();
		service.connectDB();
		service.updateEnquiry(email,phNumber);
		
		//After Update Connect with home.jsp page
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/home.jsp");
		rd.forward(request, response);
	}

}
