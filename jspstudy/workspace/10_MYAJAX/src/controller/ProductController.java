package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.ProductDelete;
import model.ProductInsert;
import model.ProductLastName;
import model.ProductName;
import model.ProductService;
import model.ProductselectList;

@WebServlet("*.go")
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
		
		ModelAndView mav = null;
		ProductService ps = null;
				
		switch(command) {
		case "selectListForm.go" :
			mav = new ModelAndView("views/selectList.jsp", false);
			break;
		
		case "selectList.go" :
			ps = new ProductselectList();
			break;
		
		case "insertForm.go" :
			mav = new ModelAndView("views/insert.jsp", true);
			break;
			
		case "ProductInsert.go" : 
			ps = new ProductInsert();
			break;
			
		case "nameCheck.go" :
			ps = new ProductName();
			break;
		case "LastNameCheck.go" :
			ps = new ProductLastName();
			break;
			
		case "delete.go" :
			ps = new ProductDelete();
			break;
		}
		
		if(ps != null) {
			mav = ps.execute(request, response);
		}
		
		if( mav == null) {
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
