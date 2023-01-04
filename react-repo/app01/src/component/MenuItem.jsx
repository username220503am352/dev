import { Link } from "react-router-dom";

export default function MenuItem(props){

    return <>
        <Link to="/main/notice">
            <div>{props.menu}</div>
        </Link>
    </>
}