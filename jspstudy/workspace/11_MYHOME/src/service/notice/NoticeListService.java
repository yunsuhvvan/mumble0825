package service.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.NoticeDao;
import dto.Notice;

public class NoticeListService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 상세 보기할 때 session에 올려 둔 notice를 제거
		HttpSession session = request.getSession();
		Notice notice =(Notice) session.getAttribute("notice");
		if(notice !=null) { //  notice가 session에 들어있으면
			session.removeAttribute("notice");
		}
		
		List<Notice> list = NoticeDao.getInstance().selectNoticeList();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("notice/list.jsp" , false);
	}

}
