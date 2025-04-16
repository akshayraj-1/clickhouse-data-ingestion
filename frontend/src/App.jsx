import {Suspense} from "react";
import {Outlet} from "react-router-dom";
import {Toaster} from "react-hot-toast";

function App() {
    return (
        <Suspense>
            <Outlet/>
            <Toaster/>
        </Suspense>
    );
}

export default App;