package model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;
import dto.BoardDto;

public class BoardInsert implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String writer = request.getParameter("writer");
		String title =  request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDto dto = new BoardDto();
	
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		

		int result = BoardDao.getInstance().Insert(dto);

		// 결과에 따른 응답(response)처리
		PrintWriter out = response.getWriter();

		// DML (insert, update, delete) 작업 후에는 redirect해야한다.
		// 자바 스크립트의 location.href redirect 이동과 같은 역할이다.
		if(result>0) {
			out.println("<script>");
			out.println("alert('등록 성공');");
			out.println("location.href='/MYB/selectBoardList.do';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}



		return null;
	}

}
