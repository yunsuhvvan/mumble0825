package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import common.ModelAndView;
import dao.ProductDao;
import dto.ProductDto;

public class ProductselectList implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<ProductDto> list = ProductDao.getInstance().selectList();
		
		JSONArray arr = new JSONArray(list);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println(arr);
		out.close();
		
		return null;
	}

}
