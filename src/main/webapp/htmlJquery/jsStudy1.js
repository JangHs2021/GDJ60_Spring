// const btn1 = document.getElementById("btn1");
const btn1 = document.querySelector("#btn1");

// querySelector == querySelectorAll[0];

// const buttons = document.getElementsByClassName("buttons");
const buttons = document.querySelectorAll(".buttons");

const d1 = document.querySelector("#d1 > .buttons li");

btn1.addEventListener("click", function(){
    console.log("btn1");
});

// for(let b of buttons){
//     b.addEventListener("click", function(){
//         console.log("buttons");
//     });
// };

let ar = [1, 2, 3];

console.log('old');
for(let i = 0; ar.length; i++) {
    console.log(ar[i]);
}

console.log('For of');
for(let a of ar) {
    console.log(a);
}

console.log('For in');
for(let j in ar) {
    console.log(j);
    console.log(ar[j]);
}

console.log('For each');
ar.forEach(function(v, i, list){
    console.log('V : ', v, 'I : ', i, 'List : ', list);
});

alert(buttons);
alert(ar);
console.log(buttons);
console.log(ar);

buttons.forEach(function(v, i){
    v.addEventListener("click", function(){
        console.log('click');
    });
;})