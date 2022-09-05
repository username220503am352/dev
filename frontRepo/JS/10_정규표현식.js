//1. 정규 표현식 객체 생성

const btn1 = document.querySelector('#btn1');

btn1.addEventListener('click' , function(){

    //const re = new RegExp('hello');
    const re = /llo/;
    const str = 'hi hello world';

    console.log(re.test(str));
    console.log(re.exec(str));

    console.log(str.match(re));
    console.log(str.replace(re, 'x'));
    console.log(str.search(re));
    console.log(str.split(re));

    /*
    정규식.test(문자열) : 조건을 만족 여부에 따라 true / false 리턴
    정규식.exec(문자열) : 처음으로 매치된 문자열 리턴

    문자열.match(정규식) : 정규식 패턴과 일치하는 값 리턴
    문자열.replace(정규식, 대체값) : 정규식 패턴과 일치하는 부분을 대체값으로 변경
    문자열.search(정규식) : 정규식 패턴과 일치하는 부분의 시작 인덱스 리턴
    문자열.split(정규식) : 정규식 패턴과 일치하는 부분을 구분자로 하여 배열 리턴
    */

});

const btn2 = document.querySelector('#btn2');
btn2.addEventListener('click', function(){

    const str = 'JAvaScript jQuery Ajax';

    console.log(str.replace(/a/ , '!'));
    console.log(str.replace(/a/i , '!'));
    console.log(str.replace(/a/g , '!'));
    console.log(str.replace(/a/ig , '!'));
    console.log(str.replace(/a/gi , '!'));

});

//메타문자
const btn3 = document.querySelector('#btn3');
btn3.addEventListener('click', function(){

    let str = 'a aa aaa aaaa aaaaa';

    /*
        {n,m}   : 패턴이 최소n번 , 최대m번 반복
        +       : 최소 한번 이상
        ?       : 최대 한번
    */

    console.log(str.replace(/a/g , '($&)'));
    console.log(str.replace(/a{1,2}/g , '($&)'));
    console.log(str.replace(/a{3}/g , '($&)'));
    console.log(str.replace(/a{2,}/g , '($&)'));
    console.log(str.replace(/a{1,}/g , '($&)'));
    console.log(str.replace(/a+/g , '($&)'));
    console.log(str.replace(/a?/g , '($&)'));
    console.log(str.replace(/a{1,3}/g , '($&)'));

    // ---------------------------------------
    console.log('------------------------');

    str = '12345 JAvascript JQuery Ajax';

    /*
    []  : 한글자
    ^   : not
    -   : 범위
    .   : 임의의 문자열
    */

    console.log(str.replace(/[ja]/ig , '($&)'));
    console.log(str.replace(/[^ja]/ig , '($&)'));
    console.log(str.replace(/[a-z]/g , '($&)'));
    console.log(str.replace(/[A-Z]/g , '($&)'));
    console.log(str.replace(/[0-9]/g , '($&)'));
    console.log(str.replace(/...../g , '($&)'));

    //-----------------------------------------------------
    console.log('------------------------');

    /*
    \d : 숫자
    \D : 숫자 아닌 문자
    \w : 알파벳 , 숫자 , 언더스코어
    \W : 알파벳 , 숫자 , 언더스코어 가 아닌 문자
    \s : 공백 (띄어쓰기 , 탭 , 줄바꿈)
    \S : 공백이 아닌 문자
    */

    str = 'aA1 B2 3C D_4 5!E';

    console.log(str.replace(/\d/g , '($&)'));
    console.log(str.replace(/\D/g , '($&)'));
    console.log(str.replace(/\w/g , '($&)'));
    console.log(str.replace(/\W/g , '($&)'));
    console.log(str.replace(/\s/g , '($&)'));
    console.log(str.replace(/\S/g , '($&)'));


});

