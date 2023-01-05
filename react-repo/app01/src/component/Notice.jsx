import { Link, Route, Routes } from "react-router-dom";
import NoticeList from "./NoticeList";
import NoticeWrite from "./NoticeWrite";

export default function Notice(){
    return <>
        <h2>공지사항 메인 !!!</h2>

        <Link to={"/main/notice/list"}>공지사항 목록 보기</Link>
        <br />
        <Link to={"/main/notice/write"}>공지사항 작성하기</Link>
        
        <Routes>
            <Route path={"list"} element={<NoticeList />}/>
            <Route path={"write"} element={<NoticeWrite />}/>
        </Routes>
        
        

    </>
}