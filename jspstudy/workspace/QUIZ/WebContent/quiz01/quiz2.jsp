<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		  request.setCharacterEncoding("utf-8");
	
		String site = request.getParameter("site");
		
		
		if(site.equals("google")){
			response.sendRedirect("https://www.google.com");
		} else if(site.equals("naver")){
			response.sendRedirect("https://www.naver.com");
		}else if(site.equals("nate")){
			response.sendRedirect("https://www.nate.com");
		} else{
			response.sendRedirect("https://www.daum.net");
		}
		
		// 2차원배열로도 접근할 수 있는 문제..
		//forward는 서버 내부 경로로 이동하기 때문에 전체 URL을 처리할 수 없다.
	   // 아래와 같이 처리하더라도 오류가 발생한다.
	%>

	