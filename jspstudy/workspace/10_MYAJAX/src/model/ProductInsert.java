package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.ProductDto;

public class ProductInsert implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

			String name = request.getParameter("name");
			Optional<String> optPrice = Optional.ofNullable(request.getParameter("price"));
			int price = Integer.parseInt(optPrice.orElse("0"));
			
			
			
			ProductDto dto = new ProductDto();
			dto.setName(name);
			dto.setPrice(price);
			
			int result = ProductDao.getInstance().insert(dto);
			
			//JSON 
			
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(obj); // 응답
			out.close();
			
			
			
			
		return null;
	}

}
