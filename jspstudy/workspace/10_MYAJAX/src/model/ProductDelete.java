package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.ModelAndView;
import dao.ProductDao;

public class ProductDelete implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

			Optional<String> optPno = Optional.ofNullable(request.getParameter("pno"));
			Long pno = Long.parseLong(optPno.orElse("0"));
			
			int result = ProductDao.getInstance().delete(pno);
			
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.close();
			
		return null;
	}

}
