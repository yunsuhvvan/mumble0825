package service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeInsertService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String ip = request.getRemoteAddr();
		
		
		Notice notice = new Notice();
		notice.setWriter(writer);
		notice.setContent(content);
		notice.setTitle(title);
		notice.setIp(ip);
		
		int result = NoticeDao.getInstance().insertNotice(notice);  // DB로 보내는 코드
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('공지사항 등록 성공')");
			out.println("location.href='list.notice'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('공지사항 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			
		}
		return null;
	}
}
