const btn1 = document.querySelector('#btn1');
const btn2 = document.querySelector('#btn2');
const btn3 = document.querySelector('#btn3');

const d1 = document.querySelector('#d1');
const d2 = document.querySelector('#d2');
const d3 = document.querySelector('#d3');

btn1.onclick = function(){
    alert('고전~~~!');
}

btn1.onclick = function(){
    alert('고전~~~!222222222');
}

btn1.onclick = null;

btn3.addEventListener('click', function(){
    alert('표준~~~~~!!!');
});

btn3.addEventListener('click', function(e){
    console.log(e);
    console.log(e.target);
    console.log(e.currentTarget);
});

//이벤트가 발생한 요소에 접근
d1.addEventListener('click',function(e){
    console.log("d1~~~!");
    //console.log(e.target);
    //console.log(e.currentTarget);
    //e.stopPropagation();
},{capture:true});

d2.addEventListener('click',function(e){
    console.log("d2~~~!");
    //console.log(e.target);
    //console.log(e.currentTarget);
    //e.stopPropagation();
});

d3.addEventListener('click',function(e){
    console.log("d3~~~!");
    //console.log(e.target);
    //console.log(e.currentTarget);
    //e.stopPropagation();
},{capture:true});



// -----------------------------------

function checkPwd(e){
    
    //기본이벤트 제거 1 (비밀번호 길이 체크)
    /*
    const pwd = document.querySelector('input[name=userPwd]');

    //비밀번호가 4글자 이상이면 ㅇㅋ
    if(pwd.value.length >= 4){
        alert('비밀번호 4글자 이상 ㅇㅋ');
        return true;
    }else{
        alert('비밀번호 4글자 이상 ㄴㄴ');
        return false;
    }
    */

    

}


const join = document.querySelector('#join');

join.addEventListener('click', checkId);

function checkId(e){
    //기본이벤트 제거 2 (정규표현식)

    const userId = document.querySelector('input[name=userId]').value;
    const reg = /^[a-zA-Z0-9]{5,10}$/;
    const result = reg.test(userId);

    if(result == false){
        alert('아이디 다시 쓰세요');
        //return false;
        e.preventDefault();
    }
}




