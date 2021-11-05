<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="quiz02.jsp">
	<h1>일반 foreach 연습</h1>
	<div>아래에 크기를 입력하면 폰트 크기를 확인할 수 있습니다.</div>
	
	<div>최소크기 <input type="text" name="min"></div>
	<div>최대크기 <input type="text" name="max"></div>
	
	
	<h1>향상 forEach 연습</h1>
	
	<input type="checkbox" value="닭갈비" name="foods">
	<input type="checkbox" value="불고기" name="foods">
	<input type="checkbox" value="순대국" name="foods">
	<input type="checkbox" value="자장면" name="foods">
	<input type="checkbox" value="해장국" name="foods">
	
	<button>전송</button>
</form>
</body>
</html>