package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.ProductDao;

public class ProductselectList implements ProductService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		request.setAttribute("list", ProductDao.getInstance().selectList());
		return new ModelAndView("views/selectList.jsp", false);
	}

}
