<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script type="text/javascript">
	$(document).ready(function () {
		$('#update_btn').on('click',function () {
			if('${notice.title}' == $('#title').val() &&
				'${notice.content}' == $('#content').val() ){
				alert('변경할 내용이 없습니다.');
				return;
			}
			$('#f').attr('action', '/ex10/notice/updateNotice');
			$('#f').submit();
		});
		
		$('#delete_btn').on('click', function () {
			if(confirm('삭제할까요?')){
				$('#f').attr('action', '/ex10/notice/deleteNotice');
				$('#f').submit();
			}
		});
	});

	
</script>
</head>
<body>

	<h1>공지사항 상세보기 및 수정화면</h1>
	
	<form id="f">
		번호 :${notice.no}<br>
		제목<br>
		<input type="text" name="title" id="title" value="${notice.title}"><br>
		내용<br>
		<textarea cols="25" rows="2" name="content" id="content">${notice.content}</textarea><br>
		작성일 : ${notice.created}<br>
		최초수정일 : ${notice.lastModified}<br><br>
		<input type="hidden" name="no" value="${notice.no}">
		<input type="button" value="수정" id="update_btn">
		<input type="button" value="삭제" id="delete_btn">
		<input type="button" value="목록" onclick="location.href='/ex10/notice/selectNoticeList'">
	</form>
	
</body>
</html>