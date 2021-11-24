<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		<li>이름 : ${param.name} </li>
		<li>나이 : ${param.age }</li>
		<li>성별 : ${param.gender}</li>
		<li>취미 :
			<c:forEach var="hobbies" items="${paramValues.hobbies}" varStatus="k">
			 	${hobbies}
			</c:forEach>
		</li>
		<li>
		    <c:forEach var="address" items="${paramValues.address}" varStatus="k">
			주소: ${address} 	
			</c:forEach>
		</li>
		<li> 좋아하는 음식:
			<c:forEach var="food" items="${paramValues.foods}">
				${food}
			</c:forEach>
		</li>
	</ul>

</body>
</html>