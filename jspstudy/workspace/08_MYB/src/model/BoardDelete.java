package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDao;

public class BoardDelete implements BoardService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Optional<String> optIdx = Optional.ofNullable(request.getParameter("idx"));
		Long idx = Long.parseLong(optIdx.orElse("0"));
		
		int result = BoardDao.getInstance().delete(idx);
		

		// 결과에 따른 응답(response)처리
		PrintWriter out = response.getWriter();

		// DML (insert, update, delete) 작업 후에는 redirect해야한다.
		// 자바 스크립트의 location.href redirect 이동과 같은 역할이다.
		if(result>0) {
			out.println("<script>");
			out.println("alert('삭제 성공');");
			out.println("location.href='/MYB/selectBoardList.do';");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
