package service.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeUpdateService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		Long nNo = Long.parseLong(request.getParameter("nNo"));
		
		
		Notice notice = new Notice();
		notice.setContent(content);
		notice.setTitle(title);
		notice.setnNo(nNo);
		
		int result = NoticeDao.getInstance().updateNotice(notice);  // DB로 보내는 코드
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("location.href='view.notice?nNo="+nNo+"'"); //nNo번쨰 상세보기를 보여줘라
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			
		}
		return null;
	}

}
