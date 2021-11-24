<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	
    	
    	
    	<%
    	// 인코딩
		request.setCharacterEncoding("utf-8");
    	
    	// input 에 입력된 값을 변수로 만든다
    	String id = request.getParameter("userId");
    	String pw = request.getParameter("userPw");
    	
    	
    	
    	// 자바빈 생성 
    	// 디폴트 생성자 이용해서 서버에 전달하는 역할
    	Member member = new Member();
    	member.setUserId(id);
    	member.setUserPw(pw);
    	// 자바 연습용 DB - > MAP
    	// Map<key , Value>
    	
    	Map<String,String> db = new HashMap<>();
    	
    	db.put("admin" , "1234");
    	db.put("superman", "1234");
    	
    	if(db.containsKey(member.getUserId())){//db에 아이디가 포함되어있는가
    		if(db.get(member.getUserId()).equals(member.getUserPw())){ //비밀번호 점검
    			session.setAttribute("loginUser", member);
    		}
    	}
    	
    	
    	
    	
    	// 로그인 성공/실패 판단
    	if(session.getAttribute("loginUser") !=null){
    		response.sendRedirect("04_cartA.jsp");
    	} else{
    		
    		response.sendRedirect("04_loginA.jsp");
    		
    	}
    	
    	
    	
    		// 로그인 화면으로 돌아가기
    	
    	%>