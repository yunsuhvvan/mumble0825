package model;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.BoardDto;

public class BoardselectList implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

				
		
		BoardDao dao = BoardDao.getInstance();
		
		request.setAttribute("Boardlist", dao.selectBoardList());
		request.setAttribute("count", dao.getCount());
		
		return new ModelAndView("views/list.jsp" , false);
	}	

}
