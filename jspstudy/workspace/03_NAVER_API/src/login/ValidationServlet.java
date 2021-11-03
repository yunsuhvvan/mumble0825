package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ValidationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean result = GetValidation.getValidation(request); // 니가 꺼내서 써라..!
		if(result) {
			out.println("<script>");
			out.println("alert('검증 성공');");
			out.println("location.href='index.jsp'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('검증 실패');");
			out.println("location.href='/naver.api/LoginServlet'");  // 로그인을 다시 하기위해 키값이랑 사진을 받아오는 loginSevlet으로 간다..
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
