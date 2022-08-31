window.onload = function(){

    //1. 배열 선언 및 초기화

    var arr01 = new Array();
    var arr02 = new Array(5);
    var arr03 = new Array("아구몬", '파닥몬', 123, 777 , true);
    var arr04 = [];
    var arr05 = ['오미라', '뢰밴' , '봉된장', arr03, {}, function(){alert('zzz');} ];

    arr01[0] = 'apple';
    arr01[1] = 'google';
    arr01[2] = 'amazon';

    console.log(arr01);
    console.log(arr02);
    console.log(arr03);
    console.log(arr04);
    console.log(arr05);



    console.log("=====배열 메소드=====");

    //2. 배열의 메소드
    var arr = ['java' , 'sql' , 'html', 'css', 'js', '자바', '디비'];
    //var arr = [30, 40, 10, 50, 99, 222];
    var ar  = ['mybatis', 'spring'];

    // indexOf : 인덱스 반환
    // console.log(arr.indexOf('css'));

    // concat : 배열 합쳐서 만들어낸 새로운 배열 리턴
    // console.log(arr.concat(ar));
    // console.log(arr);
    // console.log(ar);

    // join : 배열의 요소들을 결합해서 하나의 문자열로 리턴
    // console.log(arr.join(","));

    // reverse : 배열 순서를 뒤집는다. (원본을 뒤집음)
    // console.log(arr.reverse());
    // console.log(arr);

    // sort : 배열을 정렬한다. (오름차순) (문자기준) (원본 정렬)

    // 내림차순
    // console.log(arr.sort(function(left, right){
    //     return right - left;
    // }));
    // console.log(arr);



    //shift     : 배열의 맨 앞 요소를 반환 후 제거
    //unshift   : 배열의 맨 앞에 요소를 추가

    // console.log(ar);
    // console.log(ar.unshift('jpa'));
    // console.log(ar);


    //slice     : 요소를 가져옴     (원본 안건드림)
    //splice    : 요소 제거 및 추가 (원본 건드림)

    // console.log(arr);
    // console.log(arr.splice(2,1,'안녕ㅋㅋ', '잘가ㅎㅎ','반가워~!'));
    // console.log(arr);


    //push : 배열의 맨 뒤에 요소 추가  (원본 건드림)
    //pop  : 배열의 마지막 요소를 꺼냄 (원본 건드림)

    console.log(arr);
    console.log(arr.push('안녕ㅋㅋ'));
    console.log(arr);








}
