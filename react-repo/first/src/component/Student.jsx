import { useState } from "react";

export default function Student( props ){

    let [state , setState] = useState(props.score);

    function plusScore(){
        setState(Number(state)+1);
    }

    return <>
        <h2>학생 : {props.name} </h2>
        <h3>성적 : {state}</h3>
        <button onClick={plusScore}>성적 올려주기</button>
    </>
}