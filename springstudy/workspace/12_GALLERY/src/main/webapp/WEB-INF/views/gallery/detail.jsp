<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script>
	$(document).ready(function () {
		// 수정
		$('#update_btn').on('click' , function () {
			if(   '${gallery.title}' == $('#title').val() &&
				  '${gallery.content}' == $('#content').val() &&
				   $('#newFile').val() == '' ){
				alert('수정할 내용이 없습니다.');
				return;
			}
			$('#f').attr('action' , '/ex12/gallery/updateGallery');
			$('#f').submit();
		});
		
		// 삭제
		$('#delete_btn').on('click' , function () {
			if(confirm('삭제 하시겠습니까?')){
				$('#f').attr('action' , '/ex12/gallery/deleteGallery');
				$('#f').submit();
			}
		});
	});
</script>
</head>
<body>
		<h1>갤러리 상세 보기 화면</h1>
		
		<form id="f" method="post" enctype="multipart/form-data">
			<input type="hidden" name="path" value="${gallery.path}">
			<input type="hidden" name="saved" value="${gallery.saved}">
			<input type="hidden" name="origin" value="${gallery.origin}">
			<input type="hidden" name="no" value="${gallery.no}">  <!-- 누구를 삭제, 수정 할 것인가? (번호가 필요하다, 기준이 필요하다.) -->
			<input type="hidden" name="created" value="${gallery.created}">  <!-- 기존 첨부가 없을때 이미지를 추가할 때 필요한.. 최초 등록한 디렉토리에 수정한 이미지를 넣어주기 위해서..-->
			
			
			<input type="button" value="수정완료" id="update_btn">
			<input type="button" value="삭제완료" id="delete_btn">
			<input type="button" value="목록" onclick="location.href='/ex12/gallery/selectGalleryList'"><hr><br><br>
			작성자<br>
			${gallery.writer}<br><br>
			
			작성일<br>
			${gallery.created}<br><br>
			
			수정일<br>
			${gallery.lastModified}<br><br>
			
			작성IP<br>
			${gallery.ip}<br><br>
			
			제목<br>
			<input type="text" name="title"  id="title" value="${gallery.title}"><br><br>
			
			내용<br>
			<input type="text" name="content" id="content" value="${gallery.content}"><br>
			
			첨부 변경하기<br>
			<input type="file" name="newFile" id="newFile"><br>
		</form>
			
			<!-- 폼 분리하기 -->
			<c:if test="${not empty gallery.origin}">
				기존 첨부 : ${gallery.origin}<br><br>
				<img alt="${gallery.origin}" src="/ex12/${gallery.path}/${gallery.saved}" width="300px"><br>
				 <form action="/ex12/gallery/download" method="post">
					<input type="hidden" name="origin" value="${gallery.origin}">
					<input type="hidden" name="path" value="${gallery.path}">
					<input type="hidden" name="saved" value="${gallery.saved}">
					<button>다운로드</button>
				</form>
			</c:if>
			
		
		
</body>
</html>