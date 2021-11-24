<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    




<%
    request.setCharacterEncoding("utf-8");
    
    String userId = request.getParameter("userId");
    String userPw = request.getParameter("userPw");
    String keepLogincheck = request.getParameter("keepLogincheck");
    
    Member member = new Member();
    member.setUserId(userId);
    member.setUserPw(userPw);
    
    // admin/1234이면 로그인 성공으로 가정
    Member loginUser = null;
    if(member.getUserId().equals("admin")){
    	if(member.getUserPw().equals("1234")){
   	 }
    }
    		//loginUser는 DB에서 가져온 회원정보로 가정한다.
    		loginUser = new Member();
    		loginUser.setUserId("admin");
    		loginUser.setUserPw("1234");
    		loginUser.setUserPw("민경태");
    		
    		
    		// session에 로그인 회원정보 올리기
    		//session.setAttribute("loginUser", loginUser);
    		
    		// 브라우저를 닫은 뒤에도 로그인이 유지되려면
    		// 관련 정보를 cookie에 담아야한다.
    		// 로그인 유지 체크하면 로그인 정보를 Cookie에 저장하기
    		if(keepLogincheck != null){
    			Cookie cookie1 = new Cookie("userId" , loginUser.getUserId());
    			cookie1.setMaxAge(15 * 24 * 60  * 60 );
    			response.addCookie(cookie1);
    			Cookie cookie2 = new Cookie("userName" , loginUser.getUserName());
    			cookie2.setMaxAge(15 * 24 * 60  * 60 );
    			response.addCookie(cookie2);
    		} else{ //  로그인 유지 체크 안하면 로그인 정보를 session에 보관
    			session.setAttribute("userId", loginUser.getUserId());
    			session.setAttribute("userName", loginUser.getUserName());
    		}
    
    		// 이동
    		response.sendRedirect("03_keep_loginC.jsp");
    		
    
%>
 	
   
    