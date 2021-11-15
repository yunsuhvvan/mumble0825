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
	<style>
		label{
			display: block;
		}
	</style>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				
				fnSelectProductList();
				fnInsertProduct();
				fnNameCheck();
				fnprevInsertName();
				fnDeleteProduct();
				
			});
			
			
			
			function fnDeleteProduct() {
				$('body').on('click', '.delete_btn', function(){  // 실제로 읽을 수 있는 요소 body로 해야...
					let delete_pno = $(this).data('pno');   
					if(confirm('제품번호' +delete_pno + '제품을 삭제할까요?')){
						$.ajax({
							url : '/AJAX/delete.do',
							type : 'get',
							data : 'pno=' + delete_pno, // 서버로 보내는 데이터, 파라미터 pno로 보냄
							
							success : function(resData){
							  	if(resData.result > 0){
							  	 	alert('삭제 완료');
							  	fnSelectProductList();
							} else{
								alert('삭제 실패1')// 삭제할 회원번호가 없어서
							}
						},
							error : function(){
								alert('삭제 실패2');  // 코드 수정 필요.
							}
							
						})
					}
					
					
				});
				
				
			}
			
			
			function fnprevInsertName() {
				// 마지막 등록 제품
				$('#name_btn').on('click', function(){ //보낼 데이터가 없다.
					$.ajax({
						url: '/AJAX/prevInsertName.do',
						type : 'get',
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
			
			function fnNameCheck() {
				//제품명 중복체크
				$('#name').on('blur' , function(){
					$.ajax({
						// *SENDER*
						url : '/AJAX/nameCheck.do',   // 벗어나면 어디로(url) 갈 것이니?        action
						type: 'get',   //요청 방식											  method
						data:  'name='+$(this).val(), // 현재 이벤트 대상을 서버로 보내는 데이터 parameter
						
						// *REICEIVER*
						dataType : 'json',  		  // 받아오는 데이터 타입
						success : function(resData){  // 받아 온 실제 데이터 
							if(resData.result == false){ //nameCheck()의 result; 
								alert('동일한 제품이 있습니다');  
							}
							
						},
						error : function(){
							alert('제품명 중복 체크 실패');
						}
					});
				});
			}
			
			function fnSelectProductList() {  
				$.ajax({
					// *SENDER*
					url : '/AJAX/selectList.do',
					type : 'get',                     
				//	data :  없음  (목록을 가지고 오는 것이기 때문에 서버로 보내는 데이터가 없다.)
					
					// *RECEIVER*
					dataType : 'json',
					success : function(resData){  // resData에 SelectListService의 반환값 arr 저장
						// 제품 목록 초기화       // 생각 :  배열로 받아올때는 초기화를 해줘야하는건지..?
						$('#product_list').empty();
						// 제품 목록 만들기
						if(resData.length == 0){
							$('<tr>')
							.append( $('<td colspan="5">').text('등록된 제품이 없습니다.') )
							.appendTo('#product_list');
						} else{
							
							for(let i =0; i <resData.length; i++){
								$('<tr>')
								.append( $('<td>').text(resData[i].pno) )
								.append( $('<td>').text(resData[i].name) )
								.append( $('<td>').text(resData[i].price) )
								.append( $('<td>').text(resData[i].made) )
								.append( $('<td>').html('<input type="button" value="삭제" class="delete_btn" data-pno="'+ resData[i].pno +' ">') ) 
								.appendTo('#product_list');
							}
						}
					},
					error : function(){
						alert('제품 목록 가져오기 실패');
					}
				});
			}
			function fnInsertProduct() {
				// 제품 등록
				$('#insert_btn').on('click',  function(){
					$.ajax({
						url : '/AJAX/insert.do',
						type: 'post',
						data : $('#f').serialize(),  // ***폼의 모든 요소를 파라미터로 넘김***
						dataType : 'json', 
						success : function (resData){
							if(resData.result >0){
								alert('제품 등록 성공');
								$('#name').val('');
								$('#price').val('');
								fnSelectProductList();   // 페이지 변경없이,제품 등록 후 목록 upate하기 위해서
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
			
			
			
	
	</script>
</head>
<body>
			
		    <div>
				<h1>제품 등록 화면</h1>
				<form id="f">
					<label for="name">제품명</label>
					<input type="text" name="name" id="name">
					<input type="button" id="name_btn" value="최근 등록 제품명 확인">
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
	   		<tbody id="product_list"></tbody>	
	   </table>
		
		
</body>
</html>