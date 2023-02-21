// SELECTOR
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const address = document.getElementById("address");
const msg1 = document.getElementById("msg1");
const msg2 = document.getElementById("msg2");
const msg3 = document.getElementById("msg3");
const msg4 = document.getElementById("msg4");
const msg5 = document.getElementById("msg5");
const msg6 = document.getElementById("msg6");
const msg7 = document.getElementById("msg7");
const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

// let idCheck = false;
// let pwLengthCheck = false;
// let pwNullCheck = false;
// let pwEqualCheck = false;
// let nameCheck = false;
// let phoneCheck = false;
// let emailCheck = false;
// let addressCheck = false;
let checks = [false, false, false, false, false, false, false, false]

// ID 검증
id.addEventListener("blur", function(){
    
    if(id.value != 0){
        msg1.innerText = "ID 확인";
        // idCheck = true;
        checks[0] = true;
        msg1.className = 'blueResult';
    } else {
        msg1.innerText = "아이디는 필수 사항입니다";
        checks[0] = false;
        msg1.className = 'redResult';
    }

});

// PW 검증
pw.addEventListener("focus", function(){

    if(id.value == 0){
        msg1.innerText = "아이디를 먼저 입력하세요";
        msg1.className = 'redResult';
    }

});

pw.addEventListener("blur", function(){

    if(pw.value != 0){
        // pwNullCheck = true;
        checks[1] = true;
    } else {
        msg2.innerText = "패스워드는 필수 사항입니다";
        checks[1] = false;
        msg2.className = 'redResult';
    }

});

pw.addEventListener("keyup", function(){

    if(pw.value.length > 5 && pw.value.length < 13) {
        msg2.innerText = "정상적인 패스워드 입니다";
        msg2.className = 'blueResult';
        checks[2] = true;
        // pwLengthCheck = true;
    } else {
        msg2.innerText = "글자수는 6글자 이상 ~ 12글자 이하 입니다";
        msg2.className = 'redResult';
        checks[2] = false;
    }

});

pw.addEventListener("change", function(){

    checks[3] = false;
    pw2.value='';
    msg3.innerText = '패스워드가 틀립니다';
    msg3.className = 'redResult';
});

// PW Equal 검증
pw2.addEventListener("focus", function(){

    if(pw.value == 0){
        msg3.innerText = "패스워드를 입력하세요";
        msg3.className = 'redResult';
    }

});

pw2.addEventListener("blur", function(){

    if(pw2.value == 0){
        msg3.innerText = "패스워드를 입력하세요";
    } else if(pw.value == pw2.value) {
        msg3.innerText = "패스워드가 맞습니다";
        msg3.className = 'blueResult';
        checks[3] = true;
        // pwEqualCheck = true;
    } else {
        msg3.innerText = "패스워드가 틀립니다";
        msg3.className = 'redResult';
        checks[3] = false;
    }

});

name.addEventListener("blur", function(){
    
    if(name.value != 0){
        msg4.innerText = "";
        checks[4] = true;
    } else {
        msg4.innerText = "이름을 입력하세요";
        msg4.className = 'redResult';
        checks[4] = false;
    }

});

phone.addEventListener("blur", function(){
    
    if(phone.value != 0){
        msg5.innerText = "";
        checks[5] = true;
    } else {
        msg5.innerText = "전화번호를 입력하세요";
        msg5.className = 'redResult';
        checks[5] = false;
    }

});

email.addEventListener("blur", function(){
    
    if(email.value != 0){
        msg6.innerText = "";
        checks[6] = true;
    } else {
        msg6.innerText = "이메일을 입력하세요";
        msg6.className = 'redResult';
        checks[6] = false;
    }

});

address.addEventListener("blur", function(){
    
    if(address.value != 0){
        msg7.innerText = "";
        checks[7] = true;
    } else {
        msg7.innerText = "주소를 입력하세요";
        msg7.className = 'redResult';
        checks[7] = false;
    }

});

// Form 전송
btn.addEventListener("click", function(){
    // if(id.value != 0 && pw.value != 0 && pw2.value != 0 && name.value != 0 && email.value != 0 && phone.value != 0 && address.value != 0)
    // idCheck && pwLengthCheck && pwNullCheck && pwEqualCheck && name.value != 0 && email.value != 0 && phone.value != 0 && address.value != 0
    if(!checks.includes(false)){
        alert("회원가입 성공")
        // frm.submit();
        // btn.type = "submit";
    } else {
        alert("입력 양식을 다 채워주세요")
    } 
    
});

