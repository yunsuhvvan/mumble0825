package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.Circle;
import model.Rectangle;
import model.Shape;

 // URLMapping의 suffix가 .do인 모든 요청을 처리하는 컨트롤러 
@WebServlet("*.do")
public class Mycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Mycontroller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//URLMapping 확인
		
		String requestURI = request.getRequestURI();
		String command = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		
		// 모든 model은 Shape 인터페이스를 구현한다.
		
		// ModelAndView 선언
		ModelAndView modelAndView = null;
		
		// command에 따른 model 선택
		Shape shape = null;
		switch (command) {
		case "rectangle.do" :
			shape = new Rectangle();
			break;
			
		case "circle.do"  :
			shape = new Circle();
			break;
			
		case "input.do" : 
			modelAndView = new ModelAndView();
			modelAndView.setView("views/input.jsp");
			modelAndView.setRedirect(true);
			break;
		}
		
		// model 실행
		if(shape != null) {
			modelAndView = shape.execute(request, response);
		}		
		
		// modelAndView가 없는 경우 (ajax 처리)
		// (Model이 직접 결과를 반환하는 경우) => response를 직접 작업하는 경우
		if(modelAndView == null) {
			return;
		}
		
		
		// modelAndview가 있는 경우 (ajax 처리가 아닌 모든 경우)
		if(modelAndView.isRedirect()) { //boolean 타입의 getter/setter는 is가 붙는다
			response.sendRedirect(modelAndView.getView());
		} else {
			request.getRequestDispatcher(modelAndView.getView()).forward(request, response);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
