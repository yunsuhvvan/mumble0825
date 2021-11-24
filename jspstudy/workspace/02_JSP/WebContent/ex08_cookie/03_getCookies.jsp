<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>


<%
/*
	// 1. 사용자의 모든 쿠키 읽기
	Cookie[] cookies = request.getCookies();

	// 2. 쿠키 순회(for문)
	//인코딩 된 값은 디코딩한다.
	for(int i =0; i < cookies.length; i++){
		out.println("<h1> 쿠키 이름 : " +cookies[i].getName()   + "</h1>");
		out.println("<h1> 유효기간 : " + cookies[i].getMaxAge() + "</h1>");
		out.println("<h1> 쿠키 값 :  " +  URLDecoder.decode(cookies[i].getValue(), "utf-8") + "</h1>");
	}
	*/

%>

	<%
	// agree 쿠키만 읽기
	Cookie[] cookies = request.getCookies();
	
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("agree")){
			out.println("<h1> 쿠키 이름 : " +cookie.getName()   + "</h1>");
			out.println("<h1> 유효기간 : " + cookie.getMaxAge() + "</h1>");
			out.println("<h1> 쿠키 값 :  " +  URLDecoder.decode(cookie.getValue(), "utf-8") + "</h1>");
		}
	}
	
		/*
		out.println("<h1> 쿠키 이름 : " +cookies[0].getName()   + "</h1>");
		out.println("<h1> 유효기간 : " + cookies[0].getMaxAge() + "</h1>");
		out.println("<h1> 쿠키 값 :  " +  URLDecoder.decode(cookies[0].getValue(), "utf-8") + "</h1>");
		*/
	
	
	%>
</body>
</html>