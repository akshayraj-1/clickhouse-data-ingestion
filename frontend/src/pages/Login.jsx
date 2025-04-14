import { Navigate } from "react-router-dom";
import { useUserContext } from "../contexts/useUserContext.jsx";

function Login() {

    const { username } = useUserContext();

    return (
        username
            ? <Navigate to="/" replace={true} />
            : <section>login</section>
    )
}

export default Login;