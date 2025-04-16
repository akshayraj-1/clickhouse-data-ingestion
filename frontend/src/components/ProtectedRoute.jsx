import { Navigate } from "react-router-dom";
import { useCookies } from "react-cookie";

function ProtectedRoute({ children }) {

    const [cookies] = useCookies(["token"]);

    return (
        cookies.token ? children : <Navigate to="/login" replace={true} />
    );
}

export default ProtectedRoute;