<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	
	<%
		request.setCharacterEncoding("utf-8");
		
		
	%>
	<%-- 디폴트 생성자로 만든 빈과 동일함. --%>
	<jsp:useBean id="p1" class="ex07_bean.Book"></jsp:useBean>
	
	<%-- setter 호출 --%>
	
	<jsp:setProperty property="*" name="p1"/>    <%-- p1에 모든 properties들을 저장한다 --%>
	
	<%-- getter 호출 --%>
	<h1>제목 : <jsp:getProperty property="title" name="p1"/></h1>
	<h1>저자 : <jsp:getProperty property="author" name="p1"/></h1>
	<h1>가격 : <jsp:getProperty property="price" name="p1"/></h1>
	
	<h1>제목 : ${p1.title }</h1>
	
	<%-- 디폴트 생성자로 만든 빈 --%> 
	
	<jsp:useBean id="p2" class="ex07_bean.Book"></jsp:useBean>
	<%-- 특정 값으로 세팅한 bean  --%>
	<jsp:setProperty  name="p2" value="소나기" property="title" />
	<jsp:setProperty  name="p2" value="저자" property="author" />
	<jsp:setProperty  name="p2" value="가격" property="price" />

	<h1>제목 : ${p2.title}</h1>
	<h1>저자 : ${p2.author}</h1>
	<h1>가겨 : ${p2.price}</h1>
</body>
</html>