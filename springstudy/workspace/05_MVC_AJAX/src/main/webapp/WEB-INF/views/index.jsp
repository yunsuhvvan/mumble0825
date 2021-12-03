<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
 <script>
 	// 페이지 로드
 	$(document).ready(function() {
 		$('#btn1').on('click' , function() { fnAjax1(); });
 		$('#btn2').on('click' , function() { fnAjax2(); });
 		$('#btn3').on('click' , function() { fnAjax3(); });
 		$('#btn4').on('click' , function() { fnAjax4(); });
	});
 	
 	//함수 
 	function fnAjax1() {
		$.ajax({
			url : 'member/v1.do',   		//GetMapping의 value
			type : 'get',
			data : 'id='+$('#id').val(),
			
			dataType: 'text',				//GetMapping의 produces
			success : function(result){
				$('#result').empty();
				$('#result').text(result);
			},
			error : function(xhr){
				$('#result').empty();
				$('#result').text(xhr.responseText);
			}
		});
	} // end of fnAjax1
	
	function fnAjax2() {
		$.ajax({
			url : 'member/v2.do',
			type : 'get',
			data : $('#f').serialize(),   //form 전체를 파라미터로 넘김 
			dataType : 'json',
			success : function(member){ //  member={"id" : "aaa" "pw":"sss"} 
				$('#result').empty();
				$('<ul>')
				.append( $('<li>').text(member.id) )
				.append( $('<li>').text(member.pw) )
				.appendTo('#result');
			},
			error : function(xhr){
				$('#result').empty();
				$('#result').text(xhr.responseText);
			}
		});
	} // end of fnAjax2
	
	function fnAjax3() {
		$.ajax({
			url :'member/v3.do',
			type : 'get',
			data : $('#f').serialize(),
			dataType : 'json',
			success : function (resultMap) {
				$('#result').empty();
				$('<h1>').text(resultMap.id).appendTo('#result');
				$('<h1>').text(resultMap.pw).appendTo('#result');
			},
			error : function (xhr) {
				$('#result').empty();
				$('#result').text(xhr.responseText);
			}
		});
	} // end of fnAjax3
	
	function fnAjax4() {
		$.ajax({
			url : 'member/v4.do',
			type : 'post',					//json 데이터를 본문에 포함 시켜서 전송
			data : JSON.stringify({			//json 데이터를 문자열 형식으로 묶어서 전송
					"id" : $('#id').val(),
					"pw" : $('#pw').val()	
					}),						  // json데이터를 서버로 보냄 / 파라미터가 아님을 주의
			contentType : 'application/json', //보내는 데이터의 타입
			dataType : 'json',
			success : function (map) {
				$('#result').empty();
				$('<ol>')
				.append( $('<li>').text(map.id) )
				.append( $('<li>').text(map.pw) )
				.append( $('<li>').text(map.addOn) )
				.appendTo('#result');
			},
			error : function (xhr) {
				$('#result').empty();
				$('#result').text(xhr.responseText);
			}
		});
	} // end of fnAjax4
	
 </script>
</head>
<body>


		<form id="f">
			<input type="text" name="id"  id="id" placeholder="ID"><br>
			<input type="password" name="pw" id="pw" placeholder="Password"><br>
			<input type="button" value="전송1" id="btn1">
			<input type="button" value="전송2" id="btn2">
			<input type="button" value="전송3" id="btn3">
			<input type="button" value="전송4" id="btn4">
		</form>
		<div id="result"></div>
		
		<hr>
		
		<form id="f2">
			<input type="text" name="title" id="title" placeholder="제목"><br>
			<input type="text" name="content" id="content" placeholder="내용"><br>
			<input type="button" value="전송1" id="button1">
			<input type="button" value="전송2" id="button2">
			<input type="button" value="전송3" id="button3">
		</form>
		<div id="result2"></div>


		<script type="text/javascript">
			$('#button1').on('click', function () {
				$.ajax({
					url : 'board/v1.do',
					type : 'get',
					data : $('#f2').serialize(),   // 모든 데이터를 보내는게 bean이니까?...
					dataType : 'json',
					success : function (board) {
						$('#result2').empty();
						$('<h1>').text(board.title).appendTo('#result2');
						$('<h1>').text(board.content).appendTo('#result2');
						
					},
					error : function (xhr) {
						$('#result2').empty();
						$('#result2').text(xhr.responseText);
					}
				});
			});
			$('#button2').on('click', function () {
				$.ajax({
					url : 'board/v2.do',
					type : 'post',            //bean을 보내기 위해선 타입을 post...?
					data : JSON.stringify({
						"title"   : $('#title').val(),
						"content" : $('#content').val()
					}),
					contentType : 'application/json',
					dataType : 'json',
					success : function (board) {
						$('#result2').empty();
						$('<h1>').text(board.title).appendTo('#result2');
						$('<h1>').text(board.content).appendTo('#result2');
						
					},
					error : function (xhr) {
						$('#result2').empty();
						$('#result2').text(xhr.responseText);
					}
				});
				
			});
			$('#button3').on('click', function () {
				$.ajax({
					url : 'board/v3.do',
					type : 'post',
					data : JSON.stringify({
						"title"   : $('#title').val(),
						"content" : $('#content').val(),
						"hit" : 0
					}),
					contentType : 'application/json',
					dataType : 'json',
					success : function (board) {
						$('#result2').empty();
						$('<h1>').text(board.title).appendTo('#result2');
						$('<h1>').text(board.content).appendTo('#result2');
						$('<h1>').text(board.hit).appendTo('#result2');

					},
					error : function () {
						$('#result2').empty();
						$('#result2').text(xhr.responseText);
					}
				});
			});
		</script>


		<hr>
	
	<a href="openPapago.do">파파고</a>
	






















		
</body>
</html>