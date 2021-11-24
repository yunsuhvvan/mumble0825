package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.Product;

public class InsertService implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
//		int price = Integer.parseInt(request.getParameter("price"));
		
		int price = 0;
		String strPrice = request.getParameter("price");
		if(strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		
		// DTO
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		
		// DB에 삽입
		int result = ProductDao.getInstance().insert(product); //result는 0 아니면 1

		//JSON
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		//JSONObject obj
		// {"result" :1},  또는 {"result" : 0}
		// 응답처리
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj); //응답
		out.close();
		
		
		return null;
	}

}
