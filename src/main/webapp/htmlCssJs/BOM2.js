// const btn = document.getElementById("btn");
// let r1 = document.getElementById("r1");

// btn.addEventListener("click", function(){ 
//     console.log(r1.value * 1 + 5);
// });

const btn = document.getElementById("btn");
let r1 = document.getElementById("r1");
let c1 = document.getElementById("c1");
let t1 = document.getElementById("t1");

btn.addEventListener("click", function(){

    let result = '';
    for(let i = 0; i < r1.value; i++){
        result = result + '<tr>';
        for(let j = 0; j < c1.value; j++){
            result = result + '<td>';
            result = result + '</td>';
        }
        result = result + '</tr>';
    }
    t1.innerHTML = result;
});

const s1 = document.getElementById("s1");
const options = document.getElementsByClassName("options");

s1.addEventListener("click", function(){
    
    for(let i = 0; i < options.length; i++){
        if(options[i].selected){
            console.log(options[i].value);
            break;
        }
    }
});

const s2 = document.getElementById("s2");
const names = document.getElementsByClassName("names");

s2.addEventListener("click", function(){
    for(let i =0; i < names.length; i++){
        if(names[i].checked){
            console.log(names[i].value);
            break;
        }
    }
});

const ch = document.getElementsByClassName("ch");

for(let i = 0; i < ch.length; i++){
    ch[i].addEventListener("click", function(){
        console.log(this.checked);
        for(let j = 0; j < ch.length; j++){
            ch[j].checked = this.checked;
        }
    })
}







