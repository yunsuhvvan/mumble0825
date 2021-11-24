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
	String entertainer = request.getParameter("entertainer");
	session.setAttribute("entertainer", entertainer);
	String name = request.getParameter("name");
	session.setAttribute("name", name);
	
%>
	<form action="quiz3.jsp">
	<h1>좋아하는 운동선수는 누구인가요?</h1>
	<input type="text" name="player">
	<button>결과보기</button>
	</form>

</body>
</html>