//1. 함수 선언

//1) 선언적 함수
function f01(){
    alert('f01 called...');
}


//2) 익명 함수

var x = function(){
    alert('익명함수 호출됨...');
};

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



//2. 매개변수

//1) 매개변수 (기본값)

paramTest('asdasddas');

function paramTest(x = '기본ㅋㅋ'){
    console.log(x);
}

//2) arguments

argTest('aaa', 'bbb', 'ccc');

function argTest(){
    console.log("argTest called...");
    console.log(arguments[0]);
    console.log(arguments[1]);
    console.log(arguments[2]);
    console.log(arguments[3]);
    console.log(arguments[4]);
}


//3. 함수의 리턴

//1) 일반적인 값 리턴

var sum = plus(1,2,3,4,5);
console.log(sum);

function plus(){

    var temp = 0;
    for(var i of arguments){
        temp += i;
    }

    return temp;
}

//2) 익명함수를 리턴

var result = returnAnonymous();
var nick = 'sss';
result();

function returnAnonymous(){
    console.log("returnAnonymous called...");

    var nick = '1dragon';

    return function(){
        console.log(nick);
    };
}


//4. 내장 함수

var result = 'a' * 3; 
console.log(isNaN(result));

var result = 5 / 0 ;
console.log(isFinite(result));


var s = prompt('스크립트를 입력하세요');
eval(s);





