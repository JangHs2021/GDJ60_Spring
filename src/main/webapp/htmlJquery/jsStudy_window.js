const btn1 = document.getElementById("btn1");

btn1.addEventListener('click', function(){
   // open("./new.html", 'test', 'width=400,height=300,top=100,left=200');
    clearInterval(st);
});

// setTimeout
setTimeout(function(){
    alert('Timeout');
}, 1000);

let st = setInterval(function(){
    console.log('Interval');
}, 1000)