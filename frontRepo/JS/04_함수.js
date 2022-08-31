//1. 함수 선언

//1) 선언적 함수
function f01(){
    alert('f01 called...');
}


//2) 익명 함수

// var x = function(){
//     alert('익명함수 호출됨...');
// };

const btn01 = document.querySelector('#btn01');

btn01.addEventListener('click' , function(){
    alert('익명함수 호출됨...');
});


//3) 자동실행 함수
(
    function(){
        console.log('자동실행함수 ~~~ !');
    }()
);


//4) 화살표 함수 (arrow function)
btn01.addEventListener('click' , ()=>{
    alert('화살표 함수 호출됨 ...');
});


