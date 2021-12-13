<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		fnPwCheck();
		fnPw2Check();
		fnUpdateMember();
		fnDeleteMember();
	});
	
	// 회원 탈퇴하기
	function fnDeleteMember() {
		$('#leave_btn').on('click' , function () {
		if(confirm('삭제할까요?')){
		 	$('#f').attr('action', '/ex13/member/deleteMember');
		 	$('#f').submit();
			}
		});
	} // fnDeleteMember
	
	// 비밀번호 변경 변수와 함수
	let pwPass = false;
	function fnPwCheck() {
		$('#pw').keyup(function() {
			let regPw = /^[0-9]{1,10}$/;  // 실제 서비스는 수정해서 사용
			if ( regPw.test($(this).val()) == false ) {
				$('#pw_result').text('비밀번호는 어쩌구저쩌구입니다.').addClass('no').removeClass('ok');
				pwPass = false;
			} else {
				$('#pw_result').text('사용 가능한 비밀번호입니다.').addClass('ok').removeClass('no');
				pwPass = true;
			}
		});
	}  // end fnPwCheck
	
	// 비밀번호 입력확인 변수와 함수
	let pwPass2 = false;
	function fnPw2Check(){
		$('#pw2').keyup(function(){
			if ($('#pw').val() != $(this).val()) {
				$('#pw2_result').text('비밀번호를 확인하세요.').addClass('no').removeClass('ok');
				pwPass2 = false;
			} else {
				$('#pw2_result').text('');
				pwPass2 = true;
			}
		});
	}  // end fnPw2Check
	
	// 이메일 중복체크 변수와 함수
	let emailPass = false;
	function fnEmailCheck() {
			if( $('#email').val() == '${loginUser.email}' ){  // 사용자 이메일이 같으면 그냥 리턴시켜라
				emailPass = true;  							//이메일 안바꿧으니깐 패스했다고 봐야한다.
				return;
			}
			let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}$/;
			if ( regEmail.test($('#email').val()) == false ) {
				alert('이메일 형식을 확인하세요.');
				emailPass = false;
				return;
			}
			$.ajax({
				url: '/ex13/member/EmailCheck',
				type: 'post',
				data: 'email=' + $('#email').val(),
				dataType: 'json',
				success: function(map){
					if (map.result == null) {
						emailPass = true;
					} else {
						alert('이미 사용 중인 이메일입니다. 다른 이메일을 입력하세요.');
						emailPass = false;
					}
				},
				error: function(){
					emailPass = false;
				}
			})
	}  // end fnEmailCheck
	
	// 회원정보 변경 함수
	function fnUpdateMember() {
		
		$('#updateMember_btn').click(function () {
			if($('#email').val() == '${loginUser.email}' && 
			  $('#name').val() == '${loginUser.name}'){
				alert('변경할 내용이 없습니다.');
				return;
			} 
			fnEmailCheck();  //***
			if(emailPass == false){
				return;
			}
			
			$('#f').attr('action' , '/ex13/member/updateMember');
			$('#f').submit();
		});
	} // fnUpdateMember
	

</script>
<style>
	.no {
		color: red;
	}
	.ok {
		color: blue;
	}
</style>
</head>
<body>

	<h1>마이 페이지</h1>
	
	<form id="f" method="post">
		
		<input type="hidden" name="no"  id="no" value="${loginUser.no}">
		
		회원번호<br>
		${loginUser.no}<br>
		
		아이디<br>
		${loginUser.id}<br>
		
		가입일<br>
		${loginUser.registed}<br>
		
		현재 비밀번호<br>
		<input type="password" name="pw0" id="pw0"><br>
		
		새 비밀번호<br>
		<input type="password" name="pw" id="pw">
		<span id="pw_result"></span><br>
		
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2">
		<input type="button" value="비밀번호변경하기" id="updatePw_btn">
		<span id="pw2_result"></span><br><br>
		
		이름<br>
		<input type="text" name="name" id="name" value="${loginUser.name}"><br><br>
		
		이메일<br>
		<input type="text" name="email" id="email" value="${loginUser.email}">
		
		<input type="button" value="회원정보변경하기" id="updateMember_btn">
		<input type="button" value="되돌아가기" onclick="location.href='/ex13'"> 
		<input type="button" value="탈퇴하기" id="leave_btn">
	</form>

</body>
</html>