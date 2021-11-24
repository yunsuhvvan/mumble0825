package service.notice;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.NoticeDao;
import dao.ReplyDao;
import dto.Notice;
import dto.Reply;

public class NoticeViewService implements NoticeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {



		/*
		  null 처리하기
		  상세 보기를 수행할 게시글번호 (nNo)를 받아와야 한다.
		  전달되지 않는다면 0(없는 게시글 번호)을 사용함.
		  Long nNo는 상세 보기와 댓글 리스트에서 모두 필요함.
		 */
		Optional<String> opt = Optional.ofNullable(request.getParameter("nNo"));
		Long nNo = Long.parseLong(opt.orElse("0"));

		//session 꺼내기(내장객체가 아니기 때문에)
		HttpSession session = request.getSession();


		// 게시글을 열면 session에 "open"값 저장 할 것
		if(session.getAttribute("open")== null) { // Open을 조회/반환할 것이 없으면
			session.setAttribute("open", true);   // Open에 true를 저장한다
			// 조회수 증가 (상세보기전에 먼저 다녀와서 조회수 증가)
			NoticeDao.getInstance().updateNoticeHit(nNo);
		}


		// 게시글 번호와 일치하는 공지사항을 가져옴
		Notice notice = NoticeDao.getInstance().selectNoticeview(nNo);



		// session에 저장해 둠. (수정,삭제 작업으로 이동할 때 parameter를 넘길 필요가 없다.)
		session.setAttribute("notice", notice);




		// 일치하는 공지사항이 있는 경우
		if(notice != null) {// 검색된 결과가 있으면

			// 댓글 리스트를 가져옴
			List<Reply> replyList = ReplyDao.getInstance().selectReplyList(nNo);  //댓글의 특징이다.

			// view.jsp에서 보여줄 수 있도록 request에 저장해 둠
			request.setAttribute("replyList", replyList);

			// view.jsp에서 보여줄 수 있도록 request에 저장해 둠
			request.setAttribute("notice", notice);

			// notice/view.jsp로 forward 이동
			return new ModelAndView("notice/view.jsp", false);

		} else {  // 일치하는 공지사항이 없는 경우 경고 메세지 작성
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('일치하는 공지사항이 없습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
	}

}
