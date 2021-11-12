package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class LastNameCheck implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

			ProductDao dao =  ProductDao.getInstance();
			
			
			Product product = dao.lastCheck();
			
			
//			------------------------------------------------------
			// JSONObject 객체 생성
			JSONObject obj = new JSONObject();
			obj.put("name", product.getName()); //흠.. getName..
			
			
			
			//JSONObject obj
			// {"name" : "홈런볼"} 이걸 obj가 갖고있다.
			
			
			//JSON 데이터를 반환
			response.setContentType("application/json; charset=utf-8");  // application/json 는 정해진 키워드 타입 
			
			PrintWriter out = response.getWriter();
			out.println(obj); // JSON 데이터를 직접 응답  [insert.jsp ->$.ajax success :function(resData){} 매개변수 resData로 obj가 전달됨]
			out.close();
			
			
			
			
		return null;
	}

}
