package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.DeleteService;
import model.InsertService;
import model.LastNameCheck;
import model.NameCheckService;
import model.ProductService;
import model.SelectListService;


@WebServlet("*.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ProductController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String requestURI = request.getRequestURI();
		String contextPath =  request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		ProductService ps = null;
		ModelAndView mav = null;
		
		switch(command) {
		
		case "selectListForm.do" :
			mav = new ModelAndView("views/selectList.jsp", false);
			break;
		case "selectList.do" :
			ps = new SelectListService();
			break;
		case "insertForm.do" :
			mav = new ModelAndView("views/selectList.jsp", true);
			break;
		case "nameCheck.do" :
			ps = new NameCheckService();
			break;
		case "insert.do" :
			ps = new InsertService();
			break;
		case "prevInsertName.do" :
			ps = new LastNameCheck();
			break;
		case "delete.do" : 
			ps = new DeleteService();
			break;
		}
		
		if(ps !=null) {
			try {
				mav = ps.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(mav == null) {   //AJAX는 mav에 의해서만 이동한다.
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
