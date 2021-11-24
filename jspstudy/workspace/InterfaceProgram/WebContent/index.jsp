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
			width: 1000px;
			margin: 0 auto;
			padding: 10px;
			
		}
		.input_area{
			padding: 10px 0;
			
		}
		
		.list_area{
			width: 800px;
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
		fnSelectStaffList();
		fnInsertStaff();
		
	});
	

	function fnSelectStaffList() {
		$.ajax({
			url : 'selectStaffList.go',
			type : 'get',
		
			dataType : 'json',
			success : function(staffs){
				
				$('#staff_list').empty();
				
				$.each(staffs, function(i, staff){
					$('<tr>')
					.append( $('<td>').text(staff.sNo) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.regDate) )
					.appendTo('#staff_list');
				})
			},
			error : function() {
				alert('실패');
			}
		});
	}
	
	function fnInsertStaff() {
	 	$('#insert_btn').on('click', function(event){
	 		let regsNo = /^[0-9]{5}$/;
	 		let regdept = /^[가-힣]{3,5}$/;
	 		
	 		if(regsNo.test($('#sNo').val())==false || isNaN($('#sNo').val())){
	 			alert('사원번호는 5자리 숫자입니다.');
	 			event.preventDefault();
	 			return false;
	 		} else if (regdept.test($('#dept').val()) == false){
	 			alert('부서는 3~5 자리 한글입니다.');
	 			event.preventDefault();
	 			return false;
	 		}
			$.ajax({
				url : 'insertStaff.go',
				data : $('#f').serialize(),  
				type : 'post',
				
				dataType : 'json',
				success : function(obj){
					if(obj.result > 0){
					alert('사원 등록이 성공했습니다.');
					$('#sNo').val('');
					$('#name').val('');
					$('#dept').val('');
					fnSelectStaffList();
				} else{
					alert('사원 등록이 실패했습니다.');
				}
				},
				error : function(xhr){ 
					if(xhr.status == 1001){
						alert(xhr.responseText);
					}
				}
			});
	 	});
	 
	}
	
	</script>
</head>
<body>
		<div class="wrap">
			<h2>사원 정보 등록 프로그램</h2>
			<div class="input_area">
				<form id="f">
					<input type="text" name="sNo" id="sNo" placeholder="사원번호">
					<input type="text" name="name" id="name" placeholder="사원명">
					<input type="text" name="dept" id="dept" placeholder="부서명">
					<input type="button" value="등록하기" id="insert_btn">
				</form>
			</div>
			<div class="list_area">
				<table>
					<thead>
						<tr>
							<td>사원번호</td>
							<td>사원명</td>
							<td>부서명</td>
							<td>입사일</td>
						</tr>
					</thead>
					<tbody id="staff_list"></tbody>
				</table>
			</div>
		</div>
		
</body>
</html>