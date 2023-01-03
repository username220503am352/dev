import { useState } from "react";

export default function Person( props ){

    const [ num , setNum] = useState(props.y);
    
    function plusAge(){
        console.log("플러스 !!! ");
        setNum(Number(num) + 1);
    }

    return <>
        <hr />
        <h2>{props.x}</h2>
        <h3>나이 : {num}</h3>
        <button onClick={ plusAge }>나이증가</button>
        <hr />
    </>
}