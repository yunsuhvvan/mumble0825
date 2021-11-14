<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<form action="/MYB/insertform.do" method="post">
		<table border="1">
			<caption>총 게시글 : ${count}개</caption>
			<tbody>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
				<c:if test="${empty board}">
					<tr>
						<td colspan="4">게시물이 없습니다.</td>
					</tr>
				</c:if>
				
				<c:forEach var="board" items="${Boardlist}">
					<tr>
						<td>${board.idx}</td>
						<td>${board.writer}</td>
						<td><a href="/MYB/detail.do?idx=${board.idx}">${board.title}</a></td>
						<td>${board.register}</td>
					</tr>
				</c:forEach>
			
					<tr>
						<td colspan="4"><button>새글작성</button></td>
					</tr>
			</tbody>
		</table>
	</form>	
</body>
</html>