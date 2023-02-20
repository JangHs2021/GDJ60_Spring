const checkAll = document.getElementById("checkAll");
const check1 = document.getElementById("check1");
const check2 = document.getElementById("check2");
const check3 = document.getElementById("check3");
const checks = document.getElementsByClassName("checks");

checkAll.addEventListener("click", function(){

    for(let i = 0; checks.length; i++){
        checks[i].checked = this.checked
    }
});

for(let i = 0; i < checks.length; i++){

    checks[i].addEventListener("click", function(){
        let result = true;
        for(let j = 0; j < checks.length; j++){
            if(!checks[j].checked){
                result = false;
                break;
            } 
        }
        checkAll.checked = result;
    });
}

const agree = document.getElementById("agree");

agree.addEventListener("click", function(){
    
    if(checkAll.checked){
        //alert("모두 동의 O");
        location.href = "./setMemberAdd"
    } else {
        alert("모두 동의 X");
    }
});