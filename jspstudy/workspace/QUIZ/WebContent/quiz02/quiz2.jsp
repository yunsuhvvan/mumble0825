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
		
	  int age = Integer.parseInt(request.getParameter("age"));
	  session.setAttribute("age", age);
	  
	  if(age >=20){
		  request.getRequestDispatcher("quiz4.jsp").forward(request, response);
	  } else if(age <20){
		  request.getRequestDispatcher("quiz3.jsp").forward(request, response);
	  }
%>

		
</body>
</html>