package ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet5
 */
@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * redirect  // when database is changing
		 * 
		 * 1. 사용자에게 다시 이동해야 하는 경로를 응답(response)해준다.
		 * 2. 사용자의 요청(request)는 1회용이기 때문에 응답(response)이 오면 요청(request)은 사라진다. (parameter 더 이상 사용불가)
		 * 3. 사용자가 직접 새로운 경로로 이동하기 때문에  주소창에 이동 경로가 작성된다.
		 * 4. 
		 * */
		
		// redirect로 다른 서버로 이동해본다. (즉, 다른 Servlet으로 이동)
		// 사용자에게 다시 이동할 주소를 알려 줌.
		response.sendRedirect("/01_SERVLET/DestinationServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
