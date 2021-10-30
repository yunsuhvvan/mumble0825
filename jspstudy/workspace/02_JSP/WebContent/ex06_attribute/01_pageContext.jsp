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
	<%--pageContext에 속성 저장--%>
	<%
		pageContext.setAttribute("name", "윤수환");   // 값이 모두 object로 저장된다.
		pageContext.setAttribute("age", 28);
		
	%>
	<%-- 표현식으로 속성 사용 --%>
	<div><%=pageContext.getAttribute("name") %></div>  <%-- EL로 사용 !--%>
	<div><%=pageContext.getAttribute("age") %></div>   <%-- EL로 사용 !--%>
	
	<%-- pageContext 속성 꺼내기 --%>
	<%
		String name2 =  (String)pageContext.getAttribute("name");   // 자바 변수에 저장하면 EL로 사용하지 못한다.
		int age2 =  (Integer)pageContext.getAttribute("age");		 // 자바 변수에 저장하면 EL로 사용하지 못한다.
	%>
	<%-- 변수 name, age 사용하기 --%>
	<div>나는 <%=name2.charAt(0) %>씨다.</div>
	<div>내년에는 <%=age2+1 %>살이다...</div>
	
	<%--pageContext에 속성을 저장해 두는 이유  : EL로 활용하기 위해서--%>
	<div>${name }</div> 	
	<div>${age }</div> 	
	
	<%-- 일반 자바 변수로는 EL로 사용안됨 --%>
	<div>${name2 }</div> 	
	<div>${age2 }</div> 	






	
	
</body>
</html>