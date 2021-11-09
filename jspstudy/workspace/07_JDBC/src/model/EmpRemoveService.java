package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;

public class EmpRemoveService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		    Optional<String> optNum = Optional.ofNullable(request.getParameter("num"));
		    
			Long num =  Long.parseLong(optNum.orElse("0"));
			
			EmpDAO empDAO = EmpDAO.getInstance(); //dao를 만들어서
			int result = empDAO.deleteEmp(num); //deleteemp를 호출하고 번호를 넘겨주자
			
			ModelAndView modelAndView = null;
			
			if(result > 0 ) {
				modelAndView = new ModelAndView("/JDBC/selectList.emp", true);
			} else {  // 응답, 경고창 띄우기
				PrintWriter out = null;
				try {
					out = response.getWriter();
					out.println("<script>");
					out.println("alert('해당 사원이 삭제되지 않았습니다');");
					out.println("history.back();");
					out.println("</script>");
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
						
			}
		return modelAndView;
	}

}
