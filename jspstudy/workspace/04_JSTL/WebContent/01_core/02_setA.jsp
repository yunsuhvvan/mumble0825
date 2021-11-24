<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--age는 문자열로 저장이 됩니다.(set을 이용하게되면 문자열로 저장이된다 , 파라미터 X 속성 O) --%>
	<c:set var="age" value="28" scope="request"/>
	<% request.getRequestDispatcher("02_setB.jsp").forward(request, response); %>
</body>
</html>