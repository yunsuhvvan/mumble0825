<%@page import="java.sql.Date"%>
<%@page import="quiz10.Board"%>
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
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		board.setDate(new Date(System.currentTimeMillis()));
		
		session.setAttribute("board", board);
	%>
	
	<ul>
		<li>제목 : <%=title%></li>
		<li>작성 : <%=writer%></li>
		<li>내용 : <%=content%></li>             
		<li>게시  : ${board.date}</li>
	</ul>

</body>
</html>