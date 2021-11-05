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
			String agree = request.getParameter("agree");
			
			
			if(agree.equals("yes")){
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			
			
			}
		
		%>
</body>
</html>