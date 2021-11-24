package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardDelete;
import model.BoardDetail;
import model.BoardInsert;
import model.BoardService;
import model.BoardUpdate;
import model.BoardselectList;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		ModelAndView mav = null;
		BoardService bs = null;
		
		switch(command) {
		
		case "selectBoardList.do" :
			bs = new BoardselectList();
			break;
		case "insertform.do" : 
			mav = new ModelAndView("views/insertform.jsp", true);
			break;
			
		case "insert.do" :
			bs = new BoardInsert();
			break;
		case "detail.do" :
			bs = new BoardDetail();
			break;
			
		case "delete.do" :
			bs = new BoardDelete();
			break;
			
		case "update.do" :
			bs = new BoardUpdate();
			break;
		}
		
		
		if (bs != null) {
			try {
				mav = bs.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
