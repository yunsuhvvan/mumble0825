<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- HTML 주석 : 소스보기가 가능하다 -->
    <%-- JSP 주석 : 소스보기에서 안보인다. --%>
    
    <%--
    		   1. JSP
    		   		1) Java Server Page
    		   		2) HTML 내부에 Java 코드를 넣을 수 있다.
    		   		3) Servlet 기반이다.
    		   		    1. 실행하면 모든 JSP는 Servlet으로 변환된다.
    		   		    2. abc.jsp -> abc_jsp.java
    		   		         [JSP]      [SERVLET]
    		   2. JSP 스크립트 요소
    		   		1) <%@  %> : 지시어(directive)
    		   			1. <%@ page %>
    		   			2. <%@ include %>
    		   			3. <%@ taglib %>
    		   		2) 주석
    		   		3) <%!  %> : 선언부 (declaration)
    		   			1. 메소드 정의
    		   			2. 전역변수 선언
    		   		4) <%= %> : 표현식 (expression)
    		   			1. 변수 값
    		   			2. 연산결과
    		   			3. 메소드 호출
    		   		5) <%  %>  : 스크립트릿(scriptlet)
    		   			1. 일반 Java 코드
	    	
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 인수 2개 사이 모든 정수의 합을 반환하는 getSum() 메소드를 정의--%>
	<%!
		// 선언부
		public long getSum(long a, long b){
		if(a > b ){
			long temp;
			temp =a;
			a = b;
			b= temp;
		}
		long sum =0;
		for(long n = a; n <=b; n++){
			sum+=n;
		}
		return sum;
	}
	%>

	<%
		// 여기는 스크립트릿(일반 자바 코드)
		long result =  getSum(1,10);
		
	%>
	
	<h1>1부터 10사이 모든 정수의 합은<%=result %>입니다.</h1>
	<h1>1부터 100사이 모든 정수의 합은<%=getSum(1,100) %>입니다.</h1>
	
	<%-- 1부터 5까지 화면에 출력하기 --%>
	
	<%for(int i =1 ; i <=5; i++){%>
		<h3><%=i%></h3>
			
	<% }%>	
	
	
	

</body>
</html>