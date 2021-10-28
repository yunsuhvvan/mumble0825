<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page session="true" %>  <!--  서버 측 저장소  보안이 필요한..-->  
    
    <%
     	session.setAttribute("id", "admin");
		String id = (String)session.getAttribute("id");
    %>
    
    <script>
    	let id = '<%=id%>';
    	alert(id);
    </script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>