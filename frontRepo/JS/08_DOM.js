window.onload = function(){

    //텍스트 있는 노드 생성
    const btn1 = document.querySelector('#btn1');
    btn1.addEventListener('click' , function(){
        const span01 = document.createElement('span');
        const text01 = document.createTextNode('하이ㅋㅋ');
        span01.appendChild(text01);

        const result1 = document.querySelector('#result1');
        result1.appendChild(span01);
    });


    //텍스트 없는 노드 생성
    const btn2 = document.querySelector('#btn2');
    btn2.addEventListener('click' , function(){
        const img01 = document.createElement('img');
        img01.src = '../resources/imgs/IU.jpg';
        //img01.style.width = '100px';
        //img01.style.height = '100px';
        //img01.width = '100';
        //img01.height = '100';
        //img01.atk = 33;

        img01.setAttribute('width', '100px');
        img01.setAttribute('height', '100px');
        img01.setAttribute('atk', 33);

        console.log(img01);

        const result2 = document.querySelector('#result2');

        result2.appendChild(img01);

    });


    //노드 삭제
    const btn3 = document.querySelector('#btn3');
    btn3.addEventListener('click' , function(){

        const result3 = document.querySelector('#result3');
        const temp = document.querySelector('h3')
        console.log(temp);
        result3.removeChild();

    });

}
