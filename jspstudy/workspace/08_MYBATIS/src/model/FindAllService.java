package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDao;

public class FindAllService implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 사원 목록을 request에 저장하고,
		// 사원 목록을 보여 줄 list.jsp로 이동하는 service 진행
		
		// DB에서 사원 목록 가져오기
		// DB로 가려면 DAO가 필요함.
		EmpDao dao = EmpDao.getInstance();  // singleton 생성방법
		request.setAttribute("empList", dao.selectEmpList());  // 우리가 그렇게 원하던 사원 목록을 request에 저장한다.
		
		// 어디로 : list.jsp
		// 어떻게 : forward (request에 저장된 empList 전달을 위해서)
		return new ModelAndView("views/list.jsp", false);

	}

}
