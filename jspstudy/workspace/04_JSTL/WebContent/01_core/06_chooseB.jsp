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

		<%
			request.setCharacterEncoding("utf-8");
		%>
		
		<%-- 평균 --%>
		<%-- parameter를 EL로 사용할 때에는 param을 붙여야한다. (param.kor + ....) --%>
		<c:set var="average" value="${(param.kor + param.eng + param.mat)/3}"/>"
		
		<%-- 학점 --%>
	
		<c:choose>
		<c:when test="${average -90 >= 0}">평균 : ${average}점 ,학점 A</c:when>
		<c:when test="${average -80 >= 0}">평균 : ${average}점 ,학점 B</c:when>
		<c:when test="${average -70 >= 0}">평균 : ${average}점 ,학점 C</c:when>
		<c:when test="${average -60 >= 0}">평균 : ${average}점 ,학점 D</c:when>
		<c:otherwise>F</c:otherwise>
	</c:choose>
		
		

</body>
</html>