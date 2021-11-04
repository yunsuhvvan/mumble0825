<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- core tag library --%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 
		변수 선언 태그
		1. <c:set var="변수명" value="값" scope="영역"(4개중하나)>
		2. page, request, session, application 중 선택해서 변수를 저장한다. (default 값은 page이다)
		3. <c:set> 태그로 선언한 변수는 EL 사용이 가능하다.
	 --%>

	<%-- 1.pageContext에 저장하기 --%>
	<c:set var="name" value="민경태" scope="page"/>
	<c:set var="age" value="44"/>
	<h1>이름 : ${name }</h1>
	<h1>나이 : ${age }</h1>
	
	
	<%-- 2. request에 저장하기 --%>
	<c:set var="tel" value="010-1111-1111" scope="request"></c:set>
	<c:set var="address" value="seoul" scope="request"/>    <%--파라미터 동작이 아니라 속성동작이다 --%>
	<c:set var="height" value="177.5" scope="request"/>     <%--문자열로 저장이된다. --%>
	<c:set var="weight" value="77.6" scope="request"/>
	
	<%-- request의 전달을 위해 forward 2가지 방법 --%>
	<%request.getRequestDispatcher("01_setB.jsp").forward(request, response); %>
	<jsp:forward page="01_setB.jsp"></jsp:forward>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>