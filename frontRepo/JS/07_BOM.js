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
        y = window.setInterval(function(){
            console.log("반복 타이머~~~");
        } , 2000);
    });


    const btn5 = document.querySelector('#btn5');
    btn5.addEventListener('click', function(){
        clearInterval(y);
    });


    // --------------------------
    //location
    console.log(location);

    const btn6 = document.querySelector('#btn6');
    btn6.addEventListener('click', function(){
        location.href = 'https://www.naver.com';
    });

    const btn7 = document.querySelector('#btn7');
    btn7.addEventListener('click', function(){
        location.reload();
    });


    //navigator
    const btn8 = document.querySelector('#btn8');
    btn8.addEventListener('click', function(){
        console.log(navigator);
    });

    //screen
    const btn9 = document.querySelector('#btn9');
    btn9.addEventListener('click', function(){
        console.log(screen);
    });

    

}