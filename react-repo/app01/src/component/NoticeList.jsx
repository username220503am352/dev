import { useEffect, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

export default function NoticeList(){

    const temp = useParams();
    console.log(temp);

    const num = temp.page;
    console.log("쿼리스트링으로 전달받은 페이지 번호 : " + num);

    console.log("노티스리스트 렌더링 됨 !!!");

    const [data , setData] = useState({});

    useEffect(function(){
        
        //서버에서 데이터 받아오기 (ajax)
        fetch( "http://127.0.0.1:8888/app/board/list" , {
            method : "get" ,
        } )
        .then( ( resp ) => { return resp.json() } )
        .then( result => {
            console.log(result);
            setData(result);
        } )
        ;

    } , []);

    const navi = useNavigate();
    
    function goBack(){
        navi(-1);
    }

    const elem01 = useRef();
    console.log(elem01.current);


    return <>
        <h3 ref={elem01}>공지사항 목록</h3>

        <button onClick={goBack}>뒤로가기</button>

        <table border="1">
            <thead>
                <tr>
                    <td>제목</td>
                    <td>내용</td>
                </tr>
            </thead>    
            <tbody>
                <tr>
                    <td>{data.title}</td>
                    <td>{data.content}</td>
                </tr>
            </tbody>        
        </table>

    </>
}