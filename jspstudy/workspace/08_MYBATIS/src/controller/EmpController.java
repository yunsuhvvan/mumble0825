package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.DeleteEmpService;
import model.EmpService;
import model.FindAllService;
import model.FindOneService;
import model.InsertEmpService;
import model.UpdateEmpService;
import model.UpdateFormService;


@WebServlet("*.do")


public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmpController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();  /*  /MYBATIS/selectEmpList.do   */
		String[] arr = requestURI.split("/");         /*  {"", "MYBATIS", "selectEmpList.do"}   */
		
		ModelAndView mav = null;  // 결과를 받을 수 있게 하기 위해서
		EmpService empService = null; //모든 타입은 EmpService이다
		
		switch (arr[arr.length - 1]) { //arr[3-1],, 인덱스 0~2 
		case "selectEmpList.do":   //index.jsp에서 여기로 온다 ,사원 목록 뽑아내기
			empService = new FindAllService();
			break;
		case "selectEmp.do" :   //한 명의 정보를 가지고 오는 service
			empService = new FindOneService();
			break;
			
		case "deleteEmp.do" :
			empService = new DeleteEmpService();
			break;
		case "updateEmpForm.do" :
			empService =  new UpdateFormService();
			break;
		case "updateEmp.do" :
			empService = new UpdateEmpService();
			break;
			
		case "insertEmpForm.do": //DB로 이동하지 않는다
			mav = new ModelAndView("views/insert.jsp", false);
			break;
			
		case "insertEmp.do" : 
			empService = new InsertEmpService();
			break;
		}
		
		if (empService != null) { //정상적으로 수행하는지 확인 코드
			mav = empService.execute(request, response);  // findallserivece에서 반환 한 new ModelAndView가 여기로온다
		}
		
		
//		------------------------------응답해주는 파트----------------------------------------
		// model에서 response로 직접 이동한 경우
		if (mav == null) {   // 안막으면 NullPointerException 발생 Nullcheck 필수 
			return;
		}
		
		// redirect 또는 forward 이동
		if (mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		} else {
			request.getRequestDispatcher(mav.getView()).forward(request, response);
		}	
//		-------------------------------------------------------------------------------------
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
