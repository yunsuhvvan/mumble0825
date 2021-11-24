package service.free;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.FreeDao;
import dto.Free;

public class ReplyInsertService implements FreeService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		// 원글의 depth, groupNo, groupOrd 이다.
		int depth = Integer.parseInt(request.getParameter("depth"));
		Long groupNo  = Long.parseLong(request.getParameter("groupNo"));
		Long groupOrd  = Long.parseLong(request.getParameter("groupOrd"));
		
		String writer = request.getParameter("writer");
		String content =  request.getParameter("content");
		Optional<String> opt = Optional.ofNullable(request.getHeader("X-Forwarded-For"));
		String ip = opt.orElse(request.getRemoteAddr());
		
//		String ip = request.getHeader("X-Forwarded-For");
//		if(ip == null) {
//			ip = request.getRemoteAddr();
//		}
		
		// 삽입할 댓글 reply
		Free reply = new Free();
		reply.setDepth(depth + 1);   // 원글의 depth+1
		reply.setGroupNo(groupNo);   // 원글의 groupNo
		reply.setGroupOrd(groupOrd +1); // 원글의 groupOrd +1
		reply.setWriter(writer);     // 
		reply.setContent(content);
		reply.setIp(ip);
		
		// 원글 만들기
		Free free = new Free();
		free.setGroupNo(groupNo);
		free.setGroupOrd(groupOrd);  // 기존에 애들을 먼저 다 늘려주고 , 댓글이 들어가고
		
		
		
		// 같은 groupNo + 이미 달린 댓글 중에서 원글의 groupOrd보다 큰 값을 가지는 댓글의 groupOrd + 1 해주기
		FreeDao.getInstance().updatePreviousReplyGroupOrd(free);
		
		int result = FreeDao.getInstance().insertReply(reply);
		PrintWriter out = response.getWriter();
		
		if (result> 0){
			

			out.println("<script>");
			//out.println("alert('댓글 삽입 성공')");
			out.println("location.href='list.free'");
			out.println("</script>");
			out.close();
			
		} else {
			out.println("<script>");
			out.println("alert('댓글 삽입 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			
		}
		
		
		return null;
	}

}
