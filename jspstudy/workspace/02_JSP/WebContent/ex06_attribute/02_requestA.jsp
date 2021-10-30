<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	
	<%
		
		//request에 속성 저장하기
		
		request.setAttribute("name", "윤수환");
		request.setAttribute("age", 28);
		
		
		// request를 전달하는 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("02_requestB.jsp");
		dispatcher.forward(request, response);
	
	%>