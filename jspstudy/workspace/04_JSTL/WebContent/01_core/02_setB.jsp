<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% request.setCharacterEncoding("utf-8");%>
	
	<%--
	age는 "문자열"이기 때문에  "숫자"와 크기비교 연산은 부적절하다.
	age를 연산(-)해서 숫자로 변환한 뒤 비교한다.
	 속성은 바로 사용가능하다. 
	 getparameter 작업 불필요
	--%>
	${age -20 >= 0 ? "성인" : "미성년자"}

</body>
</html>