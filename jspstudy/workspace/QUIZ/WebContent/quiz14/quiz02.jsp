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
  <h1>일반 forEach 연습</h1>
  <c:forEach var="size" begin="${param.min }" end="${param.max }" varStatus="k">
  		<h${(param.max - param.min) -k.index}></h6>
  </c:forEach>
</body>
</html>