import { Route, Routes } from "react-router-dom";
import MenuItem from "./MenuItem";
import Notice from "./Notice";

export default function Header(){
    return <>
        
        <div className="menu">
            <MenuItem menu="공지사항" />
            <MenuItem menu="자유게시판" />
            <MenuItem menu="갤러리" />
        </div>

        <Routes>
            <Route path="notice" element={<Notice />} />
        </Routes>

    </>
}