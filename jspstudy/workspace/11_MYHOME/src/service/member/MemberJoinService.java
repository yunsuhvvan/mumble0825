package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class MemberJoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		
		Member member = new Member();
		member.setId(id);
		member.setPw(password);
		member.setEmail(email);
		member.setName(name);
	
		int result = MemberDao.getInstance().insertMember(member);
		

		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('회원가입 성공')");
			out.println("location.href='index.jsp'");
			out.println("</script>");
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
			
		}
		return null;
	}

}
