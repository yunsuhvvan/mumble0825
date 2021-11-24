<%@page import="java.net.URLEncoder"%>
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
	
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String getmarried = request.getParameter("getmarried");
		String job = request.getParameter("job");

		Cookie cookie1 = new Cookie("birthday", URLEncoder.encode(year + "년 " + month + "월 " + day + "일", "UTF-8"));
		cookie1.setMaxAge(60 * 60);
		response.addCookie(cookie1);
		Cookie cookie2 = new Cookie("getmarried", URLEncoder.encode(getmarried, "UTF-8"));
		cookie2.setMaxAge(60 * 60);
		response.addCookie(cookie2);
		Cookie cookie3 = new Cookie("job", URLEncoder.encode(job, "UTF-8"));
		cookie3.setMaxAge(60 * 60);
		response.addCookie(cookie3);
		
		
		response.sendRedirect("quiz5.jsp");
	%>
	
	
	
</body>
</html>