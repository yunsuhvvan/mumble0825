package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lotto;
import model.Now;
import model.Today;

// suffix 값이 .do인 모든 요청을 처리하라..!
@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyController() {
        super();
    }
//
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			

			// request.getRequestURI()): 요청을 확인하는 용도로 사용함(주소를 사용해서) today인지 now인지!
//			String [] arr = request.getRequestURI().split("/");
//			System.out.println(arr[arr.length -1]);
//			
			int begin = request.getRequestURI().lastIndexOf("/");
			String command = request.getRequestURI().substring(begin);  // index 글자부터 추출
			
			//if 수행문안에 객체를 넣어줌으로써  요청에 따른 Model의 선택(호출)  방법(1)
			/*
			if(command.equals("today.do")) {
				Today today = new Today();
				today.execute();
			} else if(command.equals("now.do")) {
				Now now  = new Now();
				now.execute();
			}
			*/
				
			//switch 수행문안에 객체를 넣어줌으로써  요청에 따른 Model의 선택(호출)  방법(2)
			switch (command) {
			case  "/today.do" :
				Today today = new Today();
				today.execute(request, response);
				break;
			case "/now.do" : 
				Now now = new Now();
				now.execute(request, response);
				break;
			case "/lotto.do" :
				Lotto lotto = new Lotto();
				lotto.execute(request);
				break;
			}
			

		
		
			// 응답 view로 이동
			// 경로까지 입력 request를 전달하는 forward
			//각 모델이 request에 결과를 저장해 두었다.
			request.getRequestDispatcher("views/output.jsp").forward(request, response); //today가 사용하는 request랑 같기 때문에 ...
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
