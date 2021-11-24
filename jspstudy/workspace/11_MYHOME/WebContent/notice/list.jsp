<%@page import="dto.Notice"%>
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
		
		<div>
			<c:if test="${loginUser.id == 'admin'}">
		 	<a href="/MYHOME/insertForm.notice">공지사항 작성하기</a>
		 	</c:if>
		</div>

		
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
			  <c:if test="${empty list}">
			  	<tr>
			  		<td colspan="5">없음</td>
			  	</tr>
			  </c:if>
			  <c:if test="${not empty list}">
				<c:forEach var="notice" items="${list}">
					<tr>
						<td>${notice.nNo}</td>
						<td><a href="/MYHOME/view.notice?nNo=${notice.nNo}">${notice.title}</a></td>
						<td>${notice.writer}</td>
						<td>${notice.hit}</td>
						<td>${notice.nDate}</td>
					</tr>
				</c:forEach>
			  </c:if>
			</tbody>
		</table>
		
</body>
</html>