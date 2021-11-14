package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;
import dto.ProductDto;

public class ProductLastName implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ProductDao dao = ProductDao.getInstance();
		ProductDto dto = dao.lastName();
		
		JSONObject obj = new JSONObject();
		obj.put("name", dto.getName());
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
		
		
		return null;
	}

}
