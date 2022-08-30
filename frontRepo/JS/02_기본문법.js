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
        const s2 = 10;
        console.log(s2);
    }
    console.log(s2);



    //자료형 테스트 ... 는 내일...






    


}//onload

