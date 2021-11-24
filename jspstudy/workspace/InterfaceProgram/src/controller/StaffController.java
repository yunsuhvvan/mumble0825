package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.StaffInsertService;
import model.StaffListService;
import model.StaffService;

@WebServlet("*.go")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StaffController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath =  request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		StaffService ss = null;
		ModelAndView mav = null;
		
		switch(command) {
			
		case "selectStaffList.go" : 
			ss = new StaffListService();
			break;
		case "insertStaff.go" :
			ss = new StaffInsertService();
			break;
			
		}
		
		if(ss !=null) {
			try {
				mav = ss.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(mav == null) {  
			return;
		}
		
		if(mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
