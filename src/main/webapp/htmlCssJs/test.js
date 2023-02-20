console.log("Hello World");

// 변수 선언과 대입
// 데이터타입 변수명
let num1 = 3;
num1 = "abc";

// 옛날 버전, Hoisting에 문제가 발생, 쓰지 말것
var num2 = 4;

// 상수형 변수 : final
const num3 = 5;
// num3 = 6;

let num4 = null;
// 연산자
num4 = num1 + num2; // -, *, /, %

num4 = num1 > num2; // <, >=, <=, ==, !=, ===, !==

num4 = 1;
num4 = num4 + 1;
num4++;

num1 = 3;
num2 = '3';

num4 = 'abc';
num4 = null;

console.log(typeof num4);
console.log(num1 == num2); // 값이 같아야 함
console.log(num1 === num2); // 값도 같아야하고 type도 같아야 함
console.log('NUM3 : ' + num3);
console.log('NUM1 : ' + num1);


