package service.reply;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.ReplyDao;
import dto.Reply;

public class ReplyInsertService implements ReplyService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// mapper에서 출력(insert)하고자하고싶은 것은 무조건 만들어야한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("nNo"));
		Long nNo = Long.parseLong(opt.orElse("0"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr(); // 요청한 사람의 주소 값..을 만들어야한다.  
		
		Reply reply = new Reply();
		reply.setWriter(writer);
		reply.setContent(content);
		reply.setIp(ip);
		reply.setnNo(nNo);
		
		int result = ReplyDao.getInstance().insertReply(reply);
		
		
		if(result > 0) {  // 댓글 삽입 성공하면 댓글리스트(replyList)를 DB에서 새로가져와야한다. (DB에 들렸다가 와야한다는 말.)
						  // 따라서, 댓글리스트 (replyList)를 DB에서 가져오는 서비스인 NoticeViewService를 
						  // 실행할 수 있는 view.notice 매핑으로 이동한다
			// "view.notice"로 redirect 이동함 (삽입,수정,삭제 이후에는 redirect)
			// "view.notice" 이동은 항상 nNo를 파라미터로 전달해야함
			return new ModelAndView("view.notice?nNo="+nNo, true);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 달기 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			return null;
		}
	}
}
