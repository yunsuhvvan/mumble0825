<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>회원번호 : ${member.idx} </h1>
		<h1>회원아이디 : ${member.id} </h1>
		<h1>회원이름 : ${member.name} </h1>
		
		<a href="/ex04">index로 돌아가기1</a>    <!-- @GetMapping("/") 매핑과 연결된다. -->
		<br>
		<a href="/ex04/index.do">index로 돌아가기2</a><!-- 그냥 contextPath 적는게 마음 편할지도.. -->
		<!-- 
			"/" "/index.jsp" "/index" 다 안된다
			
			contextPath를 잡아서 돌아간다.
		 -->
</body>
</html>