package model;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.BoardDto;

public class BoardDetail implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		
		BoardDto result = BoardDao.getInstance().detail(idx);
		
		request.setAttribute("result", result);
		
		return new ModelAndView("views/detail.jsp" , false);
	}

}
