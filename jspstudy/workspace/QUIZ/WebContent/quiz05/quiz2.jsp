<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>이용 약관</h3>
	----------------------------------------------------<br>
	1. 회원정보는 웹 사이트 운영을 위해서만 사용됩니다.<br>
	2. 원치 않으면 정보 제공을 하지 않을 수 있습니다.<br>
	3. 다만 이 경우 정상적인 웹 사이트 이용이 제한됩니다<br>
	____________________________________________________<br>
	<form action="quiz3.jsp">
		<h3>위 약관에 동의하십니까?</h3>
		<input type="radio" name="agree" value="yes">동의 함 
		<input type="radio" name="agree" value="no">동의안함
		<button>회원가입</button>
	</form>

</body>
</html>