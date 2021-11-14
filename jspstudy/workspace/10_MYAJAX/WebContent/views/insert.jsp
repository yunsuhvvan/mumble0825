<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		label{
			display: block;
		}
	</style>
	<script>
		$(document).ready(function(){
			
			$('#insert_btn').on('click',  function(){
				$.ajax({
					url : '/MYAJAX/ProductInsert.go',
					type: 'post',
					data : $('#form').serialize(),  // ***폼의 모든 요소를 파라미터로 넘김***
					dataType : 'json', 
					success : function (resData){
						if(resData.result >0){
							alert('제품 등록 성공.');
							$('#name').val('');
							$('#price').val('');
						} else {
							alert('제품 등록 실패.');       //ajax를 이용하면 현재 페이지에서 계속 머물게 된다.
						}
					},
					error: function(){
						alert('제품 등록 실패');
					}
				});
			});
			
			// 제품명 중복 체크
			
			$('#name').on('blur', function(){
				$.ajax({
					url : '/MYAJAX/nameCheck.go',
					type : 'get',
					data : 'name='+$(this).val(),
					dataType : 'json',
					success : function(resData){
						if(resData.result == false){
							alert('동일한 제품이 있습니다.');
						} 
					},
					error : function(){
						alert('제품명 중복 체크 실패');
					}
					
				});
			});
			
			//마지막 무슨이름?
					
			$('#recent_btn').on('click', function(){
				$.ajax({
					url: '/MYAJAX/LastNameCheck.go',
					type : 'post',
					dataType : 'json',
					success : function(resData){
						alert(resData.name);
						
					},
					error : function(){
						alert('확인 실패');
					}
					
				});
			});
			
			
			
			
			
			
			
		});
		
		
		
	</script>
</head>
<body>
	<div>
		<h1> 제품 등록 화면</h1>
		<form id="form" >	
			<label for="name">제품명</label>
			<input type="text" name="name" id="name">
			<input type="button" value="최근 등록 제품 확인" id="recent_btn">
			<label for="price">가격</label>
			<input type="text" name="price" id="price"><br>
			<input type="button" id="insert_btn" value="제품등록">
		</form>	
	</div>			
</body>
</html>