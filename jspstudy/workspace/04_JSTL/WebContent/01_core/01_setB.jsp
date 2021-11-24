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
	<h1>****파라미터(불가 null..)****</h1>
	<h1>전화 :<%=request.getParameter("tel")%></h1>  
	
	
	<h1>****자바속성****</h1>
	<h1>전화 :<%=(String)request.getAttribute("tel")%></h1>  
	<h1>주소 :<%=(String)request.getAttribute("address")%></h1> 
	
	<h1>****EL(속성)****</h1>
	<h1>전화 : ${tel}</h1>
	<h1>주소 : ${address}</h1>
	<h1>키   : ${height}cm</h1>
	<h1>몸무게:${weight}kg</h1>
	
	<c:set var="bmi" value="${weight / (height * height /10000)}"/>  <%--문자열 String의 내부변환이 있었다. --%>
	<h1>체질량:${bmi}</h1> 
	<h1>건강상태:${bmi - 25 >= 0 ? "관리필요" : "정상"}</h1> <%-- 연산은 괜찮지만 , 크기비교는 조심해야한다 연산(-+*/...)을 넣으면 문자열(bmi)도 숫자로 변환된다.--%> 
	
	${weight > height}
	
	
</body>
</html>