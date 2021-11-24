package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class SelectListService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		
		List<Product> list = ProductDao.getInstance().selectList();
		
		//-----------------------------------------------------------
//		JSONObject obj  = new JSONObject();
//		obj.put("list", list);
		
		
		JSONArray arr = new JSONArray(list);     //JSONObject 가 여러개이므로 Array를 사용해야한다.
		
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(arr);						// "arr"이 'ajax" success로 넘기는 데이터
		out.close();
		
		// 페이지 이동 막기 위해서 null 반환...
		return null;
	}

}
