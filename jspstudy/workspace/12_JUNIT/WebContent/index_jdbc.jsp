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
	<style type="text/css">
	
		*{
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		.wrap{
			width: 1500px;
			margin: 0 auto;
			padding: 10px;
			display: flex;
		}
		.input_area{
			width: 300px;
			padding: 10px;
		}
		.list_area{
			width: 1200px;
			padding: 10px;
		}
		.list_area table{
			width: 100%;
			border-collapse: collapse;
		}
		.list_area table td{
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			padding: 3px 5px;
			text-align: center;
		}
	</style>
	<script>
	
	$(document).ready(function(){
		fnSelectBoardList();
		fnInsertBoard();
		fnDeleteBoard();
		
	});
	
	
	
	function fnSelectBoardList() {
		$.ajax({
			url : 'selectBoardList.jdbc',
			type : 'get',
		//  data : 보내는 파라미터
		
			dataType : 'json',
			success : function(boards){
				// 기존 목록 지우기
				$('#board_list').empty();
				
				$.each(boards, function(i, board){
					$('<tr>')
					.append( $('<td>').text(board.bNo) )
					.append( $('<td>').text(board.writer) )
					.append( $('<td>').text(board.content) )
					.append( $('<td>').text(board.bDate) )
					.append( $('<td>').html('<input type="hidden" name="bNo" value="'+board.bNo+'"><input type="button" value="삭제" class="delete_btn">')  )
					.appendTo('#board_list');
				})
			},
			error : function() {
				alert('실패 ^^');
			}
		});
	}
	
	function fnInsertBoard() {
	 	$('#insert_btn').on('click', function(){
	 		if ( $('#bNo').val().length != 5 ){
	 			alert('게시글 번호는 5자리 입니다.');
	 			return;
	 		}
			$.ajax({
				url : 'insertBoard.jdbc',
				data : $('#f').serialize(),  // 폼의 모든 요소를 파라미터로 보냄.
				type : 'post',
				
				dataType : 'json',
				success : function(obj){
					alert(obj.result);
					$('#bNo').val('');
					$('#writer').val('');
					$('#content').val('');
					fnSelectBoardList();
				},
				error : function(xhr){ // 응답 텍스트는 xhr 객체에 responseText 프로퍼티로 전달됨.
					if(xhr.status == 2001 || xhr.status == 2002 || xhr.status == 2003){// response.setStatus(1); 코드로 보낸 값을 받음.
						alert(xhr.responseText);
					}
				}
			});
	 	});
	}
	
	function fnDeleteBoard() {
		$('body').on('click', '.delete_btn', function(){
			if(confirm('삭제할까요?')){
				$.ajax({
					url : 'deleteBoard.jdbc',
					type : 'get',
					data : 'bNo='+$(this).prev().val(),
					dataType : 'json',
					success : function(obj){
						if(obj.result >0){
							alert('삭제 성공');
							fnSelectBoardList();
						} else{
							alert('삭제 실패');
						}
					},
					error :  function(){
						alert('실패');
					}
				});
			}
		});
	}
	
	
	
	</script>
</head>
<body>
		<div class="wrap">
			<div class="input_area">
				<form id="f">
					<input type="text" name="bNo" id="bNo" placeholder="5자리 번호"><br>
					<input type="text" name="writer" id="writer" placeholder="작성자"><br>
					<input type="text" name="content" id="content" placeholder="내용"><br>
					<input type="button" value="등록하기" id="insert_btn">
				</form>
			</div>
			<div class="list_area">
				<table>
					<thead>
						<tr>
							<td>게시글번호</td>
							<td>작성자</td>
							<td>내용</td>
							<td>작성일자</td>
							<td></td>
						</tr>
					</thead>
					<tbody id="board_list"></tbody>
				</table>
			</div>
		</div>
		
</body>
</html>