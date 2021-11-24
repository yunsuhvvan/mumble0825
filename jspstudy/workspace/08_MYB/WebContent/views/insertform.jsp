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
	<form action="/MYB/insert.do" method="post">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td colspan="2"><input type="text" name="writer"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="2"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="20" rows="5" name="content"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
					<button>등록</button>
					<input type="button" value="목록" onclick="location.href='/MYB/selectBoardList.do'">
					</td>
				</tr>
			</tbody>
		</table>
	</form>	
</body>
</html>