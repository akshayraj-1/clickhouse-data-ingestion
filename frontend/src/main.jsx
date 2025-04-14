import {createRoot} from "react-dom/client";
import {createBrowserRouter, createRoutesFromElements, Route, RouterProvider} from "react-router-dom";
import {UserContextProvider} from "./contexts/useUserContext.jsx";
import "./index.css";
import App from "./App.jsx";
import Login from "./pages/Login.jsx";
import SignUp from "./pages/SignUp.jsx";
import Dashboard from "./pages/Dashboard.jsx";
import ProtectedRoute from "./components/ProtectedRoute.jsx";


const router = createBrowserRouter(
    createRoutesFromElements(
        <Route path="/" element={<App/>}>
            <Route path="/" element={<ProtectedRoute children={<Dashboard/>}/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/sign-up" element={<SignUp/>}/>
        </Route>
    )
);

createRoot(document.getElementById('root')).render(
    <UserContextProvider>
        <RouterProvider router={router}/>
    </UserContextProvider>
)
