import { Navigate } from "react-router-dom";
import { useUserContext } from "../contexts/useUserContext.jsx";

function ProtectedRoute({ children }) {

    const { username, token } = useUserContext();

    return (
        username && token ? { children } : <Navigate to="/login" replace={true} />
    );
}

export default ProtectedRoute;