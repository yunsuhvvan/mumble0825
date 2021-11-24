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
			fnameCheck();
			fnLastNameCheck();
			fnInsertProduct();
			fnselctList();
			fndeleteProduct();
			
		});
		
		function fndeleteProduct() {
			$('body').on('click','.delete_btn', function () {
				let delete_pno = $(this).data('pno');
				if(confirm('제품번호 '+ delete_pno + '에 해당하는 제품을 삭제할까여?'));
				$.ajax({
					url : '/MYAJAX/delete.go',
					type:'get',
					data : 'pno' + delete_pno,
					dataType : 'json',
					success: function (resData) {
						if(resData.result >0){
							alert('삭제완료');
							fnselctList();
						} else {
							alert('삭제 실패 1');
						}
					},
					error : function () {
						alert('삭제 실패 2');
					}
				});
			});
		}
		
		function fnameCheck() {
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
		}
		function fnLastNameCheck() {
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
		}
		function fnInsertProduct() {
			//제품 등록
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
							fnselctList();
						} else {
							alert('제품 등록 실패.');       //ajax를 이용하면 현재 페이지에서 계속 머물게 된다.
						}
					},
					error: function(){
						alert('제품 등록 실패');
					}
				});
			});
		}
		
		function fnselctList() {
			$.ajax({
				url : '/MYAJAX/selectList.go',
				type : 'get',
				
				dataType : 'json',
				success : function (resData) {
					// 제품 목록 초기화
					$('#product_list').empty();
					
					if(resData.length ==0){
						$('<tr>')
						.append( $('<td colspan="5">').text('등록된 제품이 없습니다.') )
						.appendTo('#product_list');
					} else {
						for(let i =0; i < resData.length; i++){
							$('<tr>')
							.append( $('<td>').text(resData[i].pno) )
							.append( $('<td>').text(resData[i].name) )
							.append( $('<td>').text(resData[i].price) )
							.append( $('<td>').text(resData[i].made) )
							.append( $('<td>').html('<input type="button" class="delete_btn"  value="삭제" data-pno="'+resData[i].pno+'">') )
							.appendTo('#product_list');
						}
					}
				},
				error : function () {
					alert('제품 목록 가져오기 실패');
				}
			});
		}
		
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
	   <hr>		
		
		<table border="1">
			<thead>
				<tr>
					<td>제품번호</td>
					<td>제품명</td>
					<td>제품가격</td>
					<td>제조일자</td>
					<td>버튼</td>
				</tr>
			</thead>
			<tbody id="product_list">
			</tbody>
		</table>
		
</body>
</html>