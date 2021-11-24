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
	<script>
	$(document).ready(function(){
		$('#form').on('submit', function(event){
			if( $('#title').val() == '') {
				alert('제목을 입력해주세요');
				event.preventDefault();
				$('#title').focus();
				return false;
			} else if ( $('#content').val() == '' ) {
				alert('내용을 입력해주세요');
				event.preventDefault();
				$('#content').focus();
				return false;
			} else if( $('#title').val() == '${result.title}' && $('#content').val() == '${result.content}' ){
				alert('변경 사항 없음');
				event.preventDefault();
				$('#title').focus();
				return false;
			}
			return true;
		});
		
		$('#delete_btn').on('click', function(){
			if(confirm('삭제하시겠습니까?') == false) {
				event.preventDefault();
				return false;
			} else {
				alert('삭제 성공');
				location.href='/MYB/delete.do?idx='+ ${result.idx}
			}
			return true;
		});
	});
			
	</script>
</head>
<body>
	<form action="/MYB/update.do" method="post" id="form">
		<table border="1">
			<tbody>
				<tr>
					<td>순번</td>
					<td colspan="2"><input type="text" name="idx" value="${result.idx}" readonly></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="2"><input type="text" name="writer" value="${result.writer}" readonly></td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="2"><input type="text" name="title" value="${result.title}" id="title" ></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="20" rows="5" name="content" id="content">${result.content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2">
					<button>수정</button>
					<input type="button" value="목록" onclick="location.href='/MYB/selectBoardList.do'">
					<input type="button" value="삭제"  id="delete_btn">
					</td>
				</tr>
			</tbody>
		</table>
	</form>	
</body>
</html>