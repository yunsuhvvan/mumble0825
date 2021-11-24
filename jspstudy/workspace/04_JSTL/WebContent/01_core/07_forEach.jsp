<%@page import="java.util.ArrayList"%>
<%@page import="dto.Board"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
		<%-- 1,2,3,4,5  변수를 선언한다 var--%>
		<c:forEach var="i" begin="1" end="5" step="1"> 
			${i}&nbsp;
		</c:forEach>
		<hr>
		<c:forEach var="j" begin="1" end="5" step="1">
			${(1+5) -j}
		</c:forEach>
		<hr>
		<%-- 1월 ~ 12월 --%>
		<select name=month>
			<c:forEach var="m" begin="1" end="12" step="1">
				<option value="${m}">${m}월</option>
			</c:forEach>
		</select>
		<hr>
		<%-- 배열 --%>
		<%
		String[] menu = {"김밥" ,"떡볶이" , "순대"};
		pageContext.setAttribute("menu", menu);
		%>
		<br>
		<c:forEach var="food" items="${menu}" varStatus="v">
			인덱스 : ${v.index},요소번호 :${v.count}, 요소:${food}<br>
		</c:forEach>
		<hr>
		<%--List --%>
		
		<%
			List<String> hobbies = Arrays.asList("여행" , "요가", "독서");  //자바 변수는 EL을 사용못하기때문에
			pageContext.setAttribute("hobbies", hobbies);					// 속성으로 저장해서 EL을 사용해야한다.
		%>
		
		<%--배열이나 리스트는 items를 사용해야한다 --%>
		<c:forEach var="hobbies" items="${hobbies}" varStatus="k">
			인덱스 : ${k.index}, 요소:${hobbies} <br>
		</c:forEach>
		
		<%-- List<Board> --%>
		<%
		  // 자바 bean
			List<Board> list = new ArrayList<>();
		
			list.add(new Board("공지사항", "관리자", 1589));
			list.add(new Board("필독", "카페지기", 5489));
			list.add(new Board("출석!", "서교동멋쟁이", 0));
			
			//jstl을 쓰기위해서 el이 필요하니깐 아래 문장이 반드시 필요하다.
			pageContext.setAttribute("list", list);
		%>
		
		<table border="1">
			<thead>
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="board" items="${list}" varStatus="v">
						<tr>
							<td>${v.count}</td>
							<td><a href="#?no=${v.count}">${board.title}</a></td>
							<td>${board.writer}</td>
							<td>${board.view}</td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		
		</table>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
</body>
</html>

















