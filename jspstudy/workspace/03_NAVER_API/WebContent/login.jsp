<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%--
	<%
		String filename = (String)request.getAttribute("filename");
	%>
	<%=filename %>
	--%>
	
	<h1>로그인</h1>
	<form action="/naver.api/ValidationServlet" method="post">
		<div>
			<input type="text" name="id" placeholder="ID">
		</div>
		<div>
			<input type="password" name="pw" placeholder="Password">
		</div>
	<img src="storage/${filename}" alt="캡차이미지">
	<input type="button" value="새로고침" onclick="location.href='/naver.api/LoginServlet'">
	<br>
	<input type="text" name="value">
	<input type="hidden" name="key" value="${key}">
	<div>
		<button>로그인</button>
	</div>
	</form>
	<br><br>
	







</body>
</html>