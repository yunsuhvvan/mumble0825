<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원 아이디 : ${member1.id}</h1>
	<h1>회원 비밀번호 : ${member1.pw}</h1>    <!-- 실제로 동작하는것은 getPw,getId -->
  <a href="memberView.do">회원정보보기</a>
  <br>
  <a href="boardView.do">게시글보기</a>
  
</body>
</html>