/* 각 문제는 function 내부만 작업하시오. */

$(document).ready(function(){
    fnCheckId();
    fnCheckPw();
    fnCheckName();
    fnCheckEmail();
    fnCheckSubmit();
});

// 1. 아이디
function fnCheckId(){
    let result =  false;
    let userId = $('#userId');
    let regId = /^[a-z]{1}[0-9a-z]{3,19}$/;  //첫 1글자는 영소문자 나머지 19자는 영소문자 +숫자 
    let msgId = $('#msgId');

    $(userId).on('keyup' , function () {   // userid 변수로 선언해도 wrapper로 감싸야 메서드 사용가능
        if(regId.test($(this).val())){  // 정규식.test(텍스트);
           $(msgId).text('올바른 형식입니다.');
            $(msgId).addClass('ok');
            $(msgId).removeClass('not_ok');
            result = true;
        } else {
            $(msgId).text('아이디는 소문자/숫자 4자 이상 사용 가능합니다.');
            $(msgId).addClass('not_ok');
            $(msgId).removeClass('ok');
        }
    });
    return result;
}

// 2. 비밀번호
function fnCheckPw(){
    let result = false;
    let msgPw = $('#msgPw');
    let userPw = $('#userPw');
    let regPw = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*]{8,20}$/;   //(?=)  점검  // "." 모든문자 "*"0번이상 //반드시 소문자 대문자는 1글자 이상 사용해야한다.
    $(userPw).on('blur keyup' , function () { // 전부 입력하고 빠져나갈 때
        if(regPw.test($(this).val())){
            $(msgPw).text('사용 가능한 비밀번호 입니다.');
            $(msgPw).addClass('ok');
            $(msgPw).removeClass('not_ok');
            result=true;
     } else{
        $(msgPw).text('비밀번호를 점검하세요.');
        $(msgPw).addClass('not_ok');
        $(msgPw).removeClass('ok');
     }   
  });
}
 
// 3. 이름
function fnCheckName(){  //$(userPw).on('blur keyup') 공백으로 분리해서 사용가능
    
}

// 4. 이메일
function fnCheckEmail(){
    
}

// 5. 서브밋
function fnCheckSubmit(){
    $('#join_form').on('submit' , function (event) {
        if(confirm('가입할까요?')==false){
            event.preventDefault();
            return false;
        }
        if( fnCheckId() && fnCheckPw()){

            return true;
        }
    });
}

// if(fnCheckId()){  // true가 넘어오면 submit을 하겠다.
        
// }