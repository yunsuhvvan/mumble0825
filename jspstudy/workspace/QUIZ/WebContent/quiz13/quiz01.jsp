<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="quiz02.jsp">
   		<h2>성적 입력 화면</h2>
   		<div>국어<input type="text" name=kor></div>
   		<div>영어<input type="text" name=eng></div>
   		<div>수학<input type="text" name=mat></div>
   		<button>결과보기</button>
   		<input type="button"  value="다시 작성" onlick="location.href=''quiz1.jsp">
   </form>

</body>
</html>