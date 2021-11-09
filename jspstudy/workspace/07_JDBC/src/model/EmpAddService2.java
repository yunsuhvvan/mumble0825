package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.EmpDAO;
import dto.EmpDTO;

public class EmpAddService2 implements EmpService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)  {
		
		String name = request.getParameter("name");  //이름 뺴기
		// DTO로  계층간 데이터 교환 
		EmpDTO empDTO = new EmpDTO(); // db로 보낼때 bean을 만들어서 DTO에 실었다
		empDTO.setName(name);
		
		EmpDAO empDAO = EmpDAO.getInstance();  // 객체화 시키는 것 다오에 접근
		int result = empDAO.insertEmp(empDTO);  // DTD로 받아 온 데이터를 DB에 접근하기 위해?..
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if(result>0) { // if(result== 1)
				out.println("<script>");
				out.println("alert('사원 등록이 성공하였습니다.');");
				out.println("location.href='/JDBC/selectList.emp';");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('사원 등록이 실패했습니다');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}
		

		
	}


