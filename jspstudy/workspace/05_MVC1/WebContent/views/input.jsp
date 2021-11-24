<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="/MVC/today.do">현재날짜출력</a>   
		<br>
		<a href="/MVC/now.do">현재시간출력</a>
		<br>
		<a href="/MVC/lotto.do">로또번호 6개 출력</a>
		
		<%-- 
		MyController에 넘어간 상태에서 구분할 수 있는 기준이 생겼다
		 둘의 요청을 서픽스.do라는 요청이 들어오면 모두 같은 콘트롤러가 처리..
		 앞의 단어는 무시하고  .do..
		 --%>
		
</body>
</html>