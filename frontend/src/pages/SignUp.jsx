import {Link, Navigate, useNavigate} from "react-router-dom";
import { useCookies } from "react-cookie";
import {useEffect, useRef} from "react";
import useApi from "../hooks/useApi.jsx";
import toast from "react-hot-toast";
import Button from "../components/Button.jsx";
import Authentication from "../components/Authentication.jsx";

function SignUp() {

    const usernameInput = useRef(null);
    const passwordInput = useRef(null);
    const navigate = useNavigate();
    const [cookies, setCookie] = useCookies(["token"]);
    const {post, loading, error} = useApi();

    const handleSignUpClick = async () => {
        const uname = usernameInput.current.value.trim();
        const password = passwordInput.current.value.trim();
        if (!uname || !password) {
            toast.error("Please enter username and password");
            return;
        }
        const response = await post("/auth/signup", {
            username: uname,
            password
        });
        if (response.token && response.expiresIn) {
            setCookie("token", response.token, { expires: new Date(response.expiresIn) });
            toast.success("Sign Up successful");
            navigate("/", {replace: true});
        }
    }

    useEffect(() => {
        if (error) {
            toast.error(error);
        }
    }, [error]);


    return (
        cookies.token
            ? <Navigate to="/" replace={true} />
            : <Authentication>
                <div className="flex-1 flex flex-col justify-center items-center gap-2 bg-white size-full">
                    <h1 className="font-semibold text-[25px]">Create an account</h1>
                    <p className="text-sm text-gray-500">Register with your username and password</p>
                    <input ref={usernameInput} className="text-sm text-primary px-3 py-2 mt-6 w-full max-w-xs border outline-none rounded-lg focus:ring-1 focus:ring-gray-300" type="text" placeholder="Username"/>
                    <input ref={passwordInput} className="text-sm text-primary px-3 py-2 mt-1 w-full max-w-xs border outline-none rounded-lg focus:ring-1 focus:ring-gray-300" type="password" placeholder="Password"/>
                    <Button onClick={handleSignUpClick} label="Sign Up" loading={loading} className="mt-2"/>
                    <span className="text-sm text-gray-500 mt-2">Have an account? <Link className="font-medium hover:text-primary" to="/login">Login</Link></span>
                </div>
            </Authentication>
    );
}

export default SignUp;