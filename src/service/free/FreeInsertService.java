package service.free;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.FreeDao;
import dto.Free;

public class FreeInsertService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String content =  request.getParameter("content");
		String writer = request.getParameter("writer");
//		String ip  = request.getRemoteAddr();
		String ip = request.getHeader("X-Forwarded-For");  // 다른 곳 통해서 접속
		if(ip==null) {
			ip = request.getRemoteAddr(); // 직접 접속 
		}
		

		Free free = new Free();
		free.setContent(content);
		free.setWriter(writer);
		free.setIp(ip);

		int result =  FreeDao.getInstance().insertFree(free);

		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert(' 게시글 등록 성공')");
			out.println("location.href='list.free'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('게시글 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();

		}
		return null;

	}
}

