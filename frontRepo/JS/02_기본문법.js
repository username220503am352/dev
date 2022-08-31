// 1. 변수와 자료형

// 전역 변수 선언
x = "전역변수";

// 함수 외부에 선언한 변수는 var 키워드가 붙어도 전역변수
var x2 = '전역변수2 근데 이제 var를 붙인';

// 페이지가 모두 로드되면, 실행되는 함수
// 함수 내부에, var 키워드로 변수 선언 시 지역변수
window.onload = function(){
    var x = '지역변수x';
    var y = '지역변수y'
    var z;

    console.log(x);
    console.log(window.x);
    console.log(window.x2);
    console.log(x2);
    console.log(y);
    console.log(z);

    console.log(typeof(z));

    console.log('-------------------------------------------');


    //var , let, const
    /*
        var   : 재선언 O   재할당 O 
        let   : 재선언 X   재할당 O
        const : 재선언 X   재할당 X
     */

    //1) 중복 선언
    // var temp = 10;
    // console.log(temp);

    // var temp = 20;
    // console.log(temp);

    // let temp = 10;
    // console.log(temp);

    // let temp = 10;
    // console.log(temp);

    // const temp = 10;
    // console.log(temp);

    // const temp = 10;
    // console.log(temp);



    //2) 재할당

    //var temp = 10;
    //let temp = 10;
    //const temp = 10;
    //temp = 20;
    //console.log(temp);


    //3) 스코프 (유효범위)

    // 함수 안에서 var 로 선언된 변수는 , "함수 유효 범위"

    if(true){
        var s = 10;
        console.log(s);
    }
    console.log(s);



    console.log("===========");


    // 함수 안에서 let, const 로 선언된 변수는 "블록 유효 범위"
    if(true){
        var s2 = 10; //let, const 는 에러 발생
        console.log(s2);
    }
    console.log(s2);





    //자료형 테스트
    console.log("=====자료형테스트=====");
    
    nick = '1dragon';
    age = 20;
    height = 183.7;
    weight = 88.8;
    isAdult = true;
    //games = new Array();
    //games = [];
    games = ['오버쿡2' , '마리오카트' , '테트리스'];
    //pet = new Object();
    //pet = {};
    pet = {name:'아구몬' , age:3 , gender:'male'};
    var food;
    sayHello = function f01(){alert('hello~~~!');}
    n = null;

    console.log(typeof nick);
    console.log(typeof age);
    console.log(typeof height);
    console.log(typeof weight);
    console.log(typeof isAdult);
    console.log(typeof games);
    console.log(typeof pet);
    console.log(typeof food);
    console.log(typeof sayHello);
    console.log(typeof n);





    //2. 데이터 형변환

    console.log("=====데이터 형변환=====");

    //1) 더하기 연산
    var result = 1+1;           //2
    var result = '1' + 7;       //17
    var result = 1 + '7';       //17
    var result = 1 + 1 + '7';   //27
    var result = 1 + '1' + 7;   //117

    var result = 1 * 3;         //3
    var result = 1 * '3';       //3
    var result = 1 * 'a';       //NaN //Not a Number
    var result = 'a' * 3;       //NaN
    var result = '3' * 3;       //9
    var result = '3' * '3';     //9

    console.log(result);



    


    //2) 강제 형변환
    //Number , parseInt() , parseFloat() 
    //console.log(typeof String(3));



    //3. 연산자

    console.log(3 == '3');  //true
    console.log(3 === '3'); //false
    console.log(3 === 3);   //true


    //4. 제어문

    console.log('=====제어문=====');

    var arr = [10,20,30,40,50];

    // for(var i = 0; i < arr.length; ++i){
    //     console.log(arr[i]);
    // }

    // for(var i in arr){
    //     console.log(arr[i]);
    // }

    for(var i of arr){
        console.log(i);
    }


    




    


}//onload

