//BOM

window.onload = function(){

    //window 객체
    console.log(window);

    //1. window.open
    const btn1 = document.querySelector('#btn1');

    btn1.addEventListener('click' , () => {
        //window.open();
        //window.open("https://www.naver.com");
        window.open("https://www.naver.com" , 'abc');
    });



    //2. 타이머

    const btn2 = document.querySelector('#btn2');
    btn2.addEventListener('click' , function(){
        var tab01 = window.open("https://www.naver.com");
        
        x = window.setTimeout(function(){
            tab01.close();
            //alert('탭 닫음ㅋㅋ');
        } , 1000);

    });
    
    const btn3 = document.querySelector('#btn3');
    btn3.addEventListener('click', function(){
        clearTimeout(x);
    });


    //반복 타이머
    const btn4 = document.querySelector('#btn4');
    btn4.addEventListener('click', function(){
        window.setInterval(function(){
            console.log("반복 타이머~~~");
        } , 2000);
    });


    //clearInterval 할건데, ... 내일.. 하겠습니다 ,,, 화면에 버튼 추가해서...
    

    

}