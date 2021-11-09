package model;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;

public class EmpFindEmpService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
			// 널 처리
			Optional<String> optNum = Optional.ofNullable(request.getParameter("num"));
			Long num = Long.parseLong(optNum.orElse("0"));
			
			EmpDAO empDAO = EmpDAO.getInstance();
			request.setAttribute("emp",empDAO.selectEmpDTO(num) );// 검색된 한명의 정보를 emp라는 이름으로 담아둔다
			
			
			
			
			
			
			
			return new ModelAndView("views/selectEmp.jsp" ,false);
	}

}
