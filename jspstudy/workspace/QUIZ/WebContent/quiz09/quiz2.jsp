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


  <c:forEach var="singerlist" items="${paramValues.singers}" varStatus="k">
  		좋아하는 가수${k.index+1} : ${singerlist}<br>
  </c:forEach>
</body>
</html>