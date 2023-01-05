export default function NoticeList(){

    //서버에서 데이터 받아오기 (ajax)
    fetch( "http://127.0.0.1:8888/app/board/list" , {
        method : "get" ,
    } );


    return <>
        <h3>공지사항 목록</h3>

        <table border="1">
            <thead>
                <tr>
                    <td>제목</td>
                    <td>내용</td>
                </tr>
            </thead>    
            <tbody>
                <tr>
                    <td>제목샘플ㅋㅋ</td>
                    <td>내용샘플ㅋㅋ</td>
                </tr>
            </tbody>        
        </table>

    </>
}