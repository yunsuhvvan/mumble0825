package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;

public class ProductName implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
			String name = request.getParameter("name");
			
			ProductDao dao = ProductDao.getInstance();
			
			boolean result = dao.nameCheck(name);
			
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			response.setContentType("application/json; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.println(obj); // JSON 데이터를 직접 응답  [insert.jsp ->$.ajax success :function(resData){} 매개변수 resData로 obj가 전달됨]
			out.close();
			
			
		return null;
	}

}
