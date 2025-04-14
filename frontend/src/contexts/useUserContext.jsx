import { createContext, useContext, useState } from "react";


export const UserContext = createContext({});

export function UserContextProvider({ children }) {

    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(localStorage.getItem("token"));

    return (
        <UserContext.Provider value={{ username, token, setUsername, setToken }}>
            { children }
        </UserContext.Provider>
    );
}

export function useUserContext() {
    return useContext(UserContext);
}