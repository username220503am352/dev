import { useState } from "react";

export default function Bell(){

    //let num = 10;
    const [cnt , setCnt] = useState(10);

    // let str = "카운트 감소";

    // if(cnt == 0){
    //     str = "해피뉴이어!!!";
    // }

    let str = cnt == 0 ? "해피뉴이어" : "카운트감소";


    function minusCount(){
        //num--;
        if(cnt <= 0){
            return ;
        }

        setCnt(cnt-1);
    }

    return <>
        <h2>벨</h2>
        <h4>카운트다운 : {cnt} </h4>        
        <button onClick={minusCount}>{ str }</button>
    </>
}