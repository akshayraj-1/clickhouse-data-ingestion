import { Navigate } from "react-router-dom";
import { useUserContext } from "../contexts/useUserContext.jsx";

function SignUp() {

    const { username } = useUserContext();

    return (
        username
            ? <Navigate to="/" replace={true} />
            : <section>sign up</section>
    );
}

export default SignUp;