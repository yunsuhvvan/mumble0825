package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;

public class NameCheckService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 파라미터 체크 (insert.jsp $.ajax의 data 참고)
		
		String name = request.getParameter("name");
		
		ProductDao dao = ProductDao.getInstance();
		
		//nameCheck()
		// result= true 이면 동일한 제품 없음
		boolean result = dao.nameCheck(name);  // 메서드의 반환타입이 boolean 이므로 호출결과를 저장하는 변수의 타입 역시 boolean 타입의 참조변수이여야한다.
		//----------------------------JSON--------------------------------------------------------------------------------------------
		// result를 ajax로 반환할 수 있도록 JSON 데이터로 변환
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		//JSONObject obj
		// {"result" :true}, {"result" : false}
		
		//JSON 데이터를 반환
		response.setContentType("application/json; charset=utf-8");  // application/json 는 정해진 키워드 타입 
		
		PrintWriter out = response.getWriter();
		out.println(obj); // JSON 데이터를 직접 응답  [insert.jsp ->$.ajax success :function(resData){} 매개변수 resData로 obj가 전달됨]
		out.close();
		
		
		// ajax인 처리인 경우 null 반환 -> controller에서 redirect/forward 이동을 막아줌
		
		return null;
	}

}
