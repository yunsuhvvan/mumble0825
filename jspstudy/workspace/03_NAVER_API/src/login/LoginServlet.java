package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. captcha key 받아오기
		String key = GetKey.getkey();
		GetImage.getImage(key,request);
		request.setAttribute("key", key);
		
		// 로그인 화면으로 가서 다운받은 이미지 보여주기
		// 포워드 : request 가지고 이동 - request에 파일명 저장하고 포워딩하기
		// 리다이렉트 : request 없이 이동
		request.getRequestDispatcher("login.jsp").forward(request,response);
		
//		request.getRequestDispatcher("폴더/login.jsp").forward(request,response);
		
		
		//request.getServletContext().getRealPath(path);  //암기하기
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
