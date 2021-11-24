package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.free.FreeDeleteService;
import service.free.FreeFindService;
import service.free.FreeInsertService;
import service.free.FreeListService;
import service.free.FreeService;
import service.free.FreeUpdateService;
import service.free.FreeViewService;
import service.free.ReplyInsertService;

@WebServlet("*.free")
public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			String requestURI = request.getRequestURI();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length()+1);
			
			ModelAndView mav = null;
			FreeService service = null;
			switch(command) {
			
			case "list.free" : 
				service = new FreeListService();
				break;
			case "insertForm.free" :
				mav = new ModelAndView("free/insert.jsp", false);
				break;
			case "insert.free" :
				service = new FreeInsertService();
				break;
			case "view.free" :
				service = new FreeViewService();
				break;
			case "updateForm.free" : 
				mav = new ModelAndView("free/update.jsp", false);
				break;
				
			case "update.free" :
				service = new FreeUpdateService();
				break;
				
			case "delete.free" :
				service = new FreeDeleteService();
				break;
			case "insertReply.free" : 
				service = new ReplyInsertService();
				break;
			case "find.free" : 
				service = new FreeFindService();
				break;
			}
			
			if(service != null) {
				try {
					mav = service.execute(request, response);
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
